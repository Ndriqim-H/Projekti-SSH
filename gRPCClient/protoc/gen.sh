OS_DIR='./win' # windows: './win'

PROTO_PATH="$OS_DIR/bin/protoc.exe"
GRPC_JAVA_PLUGIN="$OS_DIR/plugins/protoc-gen-grpc-java"
# GRPC_RUBY_PLUGIN="$OS_DIR/plugins/protoc-gen-grpc-ruby"
DIR_OF_PROTO_FILE='../proto-defs/'

# # Hello world
# PROTO_FILE='../proto-defs/hello_world.proto'
# CODE_DIR='../hello_world'

# Booksys
PROTO_FILE='../proto-defs/client.proto'
CODE_DIR='../Yahtzee' #'../hello_world'

JAVA_OUT_PATH="../java/app/src/main/java"
# RUBY_OUT_PATH="$CODE_DIR/ruby/lib"

if [ "$1" == 'java' ]; then
  $PROTO_PATH --plugin=$GRPC_JAVA_PLUGIN \
  --proto_path="$DIR_OF_PROTO_FILE" \
  --java_out="$JAVA_OUT_PATH" \
  --grpc-java_out="$JAVA_OUT_PATH" \
  "$PROTO_FILE"
fi

if [ "$1" == 'ruby' ]; then
  $PROTO_PATH --plugin="$GRPC_RUBY_PLUGIN" \
  --proto_path="$DIR_OF_PROTO_FILE" \
  --ruby_out="$RUBY_OUT_PATH" \
  --grpc-ruby_out="$RUBY_OUT_PATH" \
  "$PROTO_FILE"
fi
