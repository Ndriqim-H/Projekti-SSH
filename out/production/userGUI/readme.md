# Simple json/xml serialization

## Tools

- https://nodejs.org/en/
- https://dotnet.microsoft.com/download
- https://code.visualstudio.com/download
- https://git-scm.com/download/win (windows only!)
- https://marketplace.visualstudio.com/items?itemName=ms-dotnettools.csharp
- https://stackoverflow.com/questions/44435697/vscode-change-default-terminal (change default terminal to git bash!!!) 
- https://code.visualstudio.com/docs/languages/java
- https://marketplace.visualstudio.com/items?itemName=redhat.vscode-xml
- https://linuxize.com/post/how-to-install-apache-maven-on-ubuntu-18-04/
- https://mkyong.com/maven/how-to-install-maven-in-windows/


## Setup and usage

### Node

Install:
```
cd node-project
npm install
```

Usage examples:
```
node index.js json ser ../node.json
node index.js json des ../node.json
node index.js xml ser ../node.xml
node index.js xml des ../node.xml
```

### Java

Install:
```
cd java-project
bash build.sh
```

Usage examples:
```
java -jar my-app.jar json ser ../node.json
java -jar my-app.jar json des ../node.json
java -jar my-app.jar xml ser ../node.xml
java -jar my-app.jar xml des ../node.xml
```

### .NETCORE

Install:
```
cd dotnet-project
# edit build.sh, set OS=win-x64 or OS=linux-x64 depending on operating sys 
bash build.sh
```

Usage examples (linux):
```
./.bin/dotnet-project json ser ../node.json
./.bin/dotnet-project json des ../node.json
./.bin/dotnet-project xml ser ../node.xml
./.bin/dotnet-project xml des ../node.xml
```

Usage examples (win):
```
./.bin/dotnet-project.exe json ser ../node.json
./.bin/dotnet-project.exe json des ../node.json
./.bin/dotnet-project.exe xml ser ../node.xml
./.bin/dotnet-project.exe xml des ../node.xml
```


## Used packages

**Node**
- https://www.npmjs.com/package/xml2js

**Java**
- https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.6
- https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-xml/2.9.8

**.NETCORE**
- https://www.nuget.org/packages/Newtonsoft.Json/12.0.3
- https://www.nuget.org/packages/Microsoft.XmlSerializer.Generator/1.0.0


## Additional resources

- https://www.youtube.com/watch?v=RLtyhwFtXQA
- https://javascript.info/async
- https://www.npmjs.com/package/xml2js
- https://maven.apache.org/guides/getting-started/
- https://mkyong.com/java/how-to-parse-json-with-gson/
- https://www.baeldung.com/jackson-xml-serialization-and-deserialization
- https://docs.microsoft.com/en-us/dotnet/core/about
- https://code.visualstudio.com/docs/languages/dotnet
- https://docs.microsoft.com/en-us/dotnet/standard/serialization/examples-of-xml-serialization
- https://www.newtonsoft.com/json
