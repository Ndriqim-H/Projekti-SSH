# GRPC Book management sys

## Languages
- Java - https://www.java.com/en/download/manual.jsp
- NodeJS - https://nodejs.org/en/download/
- Ruby - [linux](http://rvm.io/) | [win](https://rubyinstaller.org/) (download +devkit ones)

## Tools
- vscode - https://code.visualstudio.com/download
- git bash (win only) - [download url](https://git-scm.com/download/win) | [change vscode terminal to bash](https://stackoverflow.com/questions/44435697/vscode-change-default-terminal)
- maven - [win](https://mkyong.com/maven/how-to-install-maven-in-windows/) | [linux](https://linuxize.com/post/how-to-install-apache-maven-on-ubuntu-18-04/)
- java vscode tools - https://code.visualstudio.com/docs/languages/java
- xml vscode tools - https://marketplace.visualstudio.com/items?itemName=redhat.vscode-xml
- ruby vscode tools - https://marketplace.visualstudio.com/items?itemName=rebornix.Ruby
- proto3 vscode tools - https://marketplace.visualstudio.com/items?itemName=zxh404.vscode-proto3

## Setup dev env guide

Before starting to use the project create three folders in same dir with protoc folder:
```
[working dir]/
|
|-- hello_world/
|   |-- java/
|   |-- node/
|   |-- ruby/
|
|-- protoc/
|
```

### Java project

Then goto java directory and run the following commands:
```
cd hello_world/java/
mvn org.apache.maven.plugins:maven-archetype-plugin:3.1.2:generate -DarchetypeArtifactId="archetype-quickstart-jdk8" -DarchetypeGroupId="com.github.ngeor" -DarchetypeVersion="1.2.0"

# interactive cli
Define value for property 'groupId': app
Define value for property 'artifactId': app
Define value for property 'version' 1.0-SNAPSHOT: : 1.0
Define value for property 'package' app: : app
Confirm properties configuration:
groupId: app
artifactId: app
version: 1.0
package: app
 Y: : Y

cd app
```

Paste the required grpc dependencies in `hello_world/java/app/pom.xml` under `<dependencies>` section:
```xml
    <dependency>
      <groupId>io.grpc</groupId>
      <artifactId>grpc-netty-shaded</artifactId>
      <version>1.28.1</version>
    </dependency>
    <dependency>
      <groupId>io.grpc</groupId>
      <artifactId>grpc-protobuf</artifactId>
      <version>1.28.1</version>
    </dependency>
    <dependency>
      <groupId>io.grpc</groupId>
      <artifactId>grpc-stub</artifactId>
      <version>1.28.1</version>
    </dependency>
```
Also add this xml section inside `build/pluginManagement/plugins` tag:
```xml
      <plugin>
        <artifactId>maven-assembly-plugin</artifactId>
        <configuration>
          <archive>
            <manifest>
              <mainClass>app.App</mainClass>
            </manifest>
          </archive>
          <descriptorRefs>
            <descriptorRef>jar-with-dependencies</descriptorRef>
          </descriptorRefs>
        </configuration>
        <executions>
          <execution>
            <id>make-assembly</id>
            <phase>package</phase>
            <goals>
              <goal>single</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
```

Then inside app folder run `mvn package`, this will install the dependencies

### Node project

Simply go to node folder and run the following commands:
```
cd hello_world/node/
npm init
# just click enter to all questions
npm install --save @grpc/proto-loader grpc
```

### Ruby Project

Go to ruby folder and run the following commands:
```
cd hello_world/ruby/
gem install bundler
gem install grpc
gem install grpc-tools

bundler init
```

Edit content of `Gemfile` to be like this:
```Gemfile
# frozen_string_literal: true

source "https://rubygems.org"

# git_source(:github) {|repo_name| "https://github.com/#{repo_name}" }

# gem "rails"
gem "grpc"

```

Run the following commands:
```
mkdir lib
bundler install
```

### Setting up protoc and GRPC
In project workspace create a file `proto-defs/hello_world.proto` and write this content:

```proto
syntax = "proto3";
option java_package = "app";

package helloworld;

service Greeter {
  rpc sayHello(HelloRequest) returns (HelloResponse) {}
}

message HelloRequest { string name = 1; }

message HelloResponse { string message = 1; }

```

Then goto protoc folder and edit the content of `gen.sh` by setting OS_DIR to your operating system. Then run the following commands:
```
bash gen.sh java
bash gen.sh ruby
```

This will generate the classes from protoc to corresponding folders:
```
hello_world/java/app/src/main/java/app/GreeterGrpc.java
hello_world/java/app/src/main/java/app/HelloWorld.java
hello_world/ruby/lib/hello_world_pb.rb
hello_world/ruby/lib/hello_world_services_pb.rb
```

Then you have to remove this part from `GreeterGrpc.java`:
```java
/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.1)",
    comments = "Source: hello_world.proto")
```
Also replace line `require 'hello_world_pb'` in `hello_world_services_pb.rb` with:
```ruby
require_relative 'hello_world_pb'
```

For node js create a file named `hello_world/node/grpc-defs.js` and write this content:
```javascript
'use strict'

const grpc = require('grpc')
const protoLoader = require('@grpc/proto-loader')

const PROTO_PATH = __dirname + '/../../proto-defs/hello_world.proto'
const packageDefinition = protoLoader.loadSync(PROTO_PATH, {
  keepCase: true,
  longs: String,
  enums: String,
  defaults: true,
  oneofs: true
})

const defs = grpc.loadPackageDefinition(packageDefinition)

module.exports = defs

```

The part so far generates the stubs for `hello_world.proto`. Now we have to create the clients and the server. The server will be in node js so we can create a file `hello_world/node/server.js` and paste this sample code to run the server:
```javascript
'use strict'

const grpc = require('grpc')
const defs = require('./grpc-defs')
const { Greeter } = defs.helloworld

const server = new grpc.Server()
server.addService(Greeter.service, {
  sayHello: (call, cb) => {
    cb(null, { message: call.request.name })
  }
})

server.bindAsync('0.0.0.0:7070', grpc.ServerCredentials.createInsecure(), (err, port) => {
  console.log('server started listening on port ' + port)
})
server.start()

```

And the we can create a client for it in javascript `hello_world/node/client.js`:
```javascript
'use strict'

const grpc = require('grpc')
const defs = require('./grpc-defs')
const { Greeter } = defs.helloworld

const client = new Greeter('localhost:7070', grpc.credentials.createInsecure())
client.sayHello({ name: 'test node' }, (err, res) => {
  console.log(err, res)
})

```

For java we'll be setting only a client where we'll replace content of `hello_world/java/app/src/main/java/app/App.java` with this:
```java
package app;

import app.HelloWorld.HelloRequest;
import app.HelloWorld.HelloResponse;
import io.grpc.*;

public final class App {
    public static void main(String[] args) {
        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc
                .newBlockingStub(ManagedChannelBuilder.forTarget("localhost:7070").usePlaintext().build());
        HelloResponse response = stub.sayHello(HelloRequest.newBuilder().setName("test java").build());
        System.out.println(response.getMessage());
    }
}

```

For ruby we'll also setup a client only where we'll have to create a file `hello_world/ruby/client.rb` and put this content on it:
```ruby
require "grpc"
require_relative "lib/hello_world_pb"
require_relative "lib/hello_world_services_pb"

stub = Helloworld::Greeter::Stub.new("localhost:7070", :this_channel_is_insecure)
res = stub.say_hello(Helloworld::HelloRequest.new(name: "test ruby"))
p "Greeting: #{res.message}"

```

Now that we have setup the env we can run the server and the clients:
```
# Server
node ./hello_world/node/server.js

# Clients
mvn clean compile assembly:single -f ./hello_world/java/app/pom.xml
java -jar ./hello_world/java/app/target/app-1.0-jar-with-dependencies.jar

node ./hello_world/node/client.js

ruby ./hello_world/ruby/client.rb
```


## GRPC DOCS

- General: https://grpc.io/docs/guides/
- Java: https://grpc.io/docs/tutorials/basic/java/
- Node: https://grpc.io/docs/tutorials/basic/node/
- Ruby: https://grpc.io/docs/tutorials/basic/ruby/

## Booksys docs

Installing packages
```
cd booksys/node
npm install

cd ../ruby
bundle install

cd ../java/app
mvn package
```

Running server (from root workspace dir):
```
node booksys/node/server.js 
```

Running clients:
```
# Node
node booksys/node/client.js

# Ruby
ruby booksys/ruby/client.rb

# Java
mvn clean compile assembly:single -f ./booksys/java/app/pom.xml
java -jar booksys/java/app/target/app-1.0-jar-with-dependencies.jar
```
