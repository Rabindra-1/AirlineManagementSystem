#!/bin/bash

# --- 1. Define Paths and Names ---
# NOTE: Update these paths if your file names or paths change!
MAIN_CLASS="Login" # This is usually the class with main(String[] args)
JAR_NAME="AirlineManagementSystem.jar"
OUT_DIR="out/artifacts/AirlineManagementSystem_jar"
TEMP_DIR="temp_classes"
MANIFEST="Manifest.txt"

# --- 2. Create Required Directories ---
mkdir -p "$OUT_DIR"
mkdir -p "$TEMP_DIR"

# --- 3. Create Manifest File ---
echo "Main-Class: $MAIN_CLASS" > "$MANIFEST"

# --- 4. Compile Java Files ---
echo "Compiling Java files..."
# Compiles all .java files into the temp_classes directory
# Assumes all necessary Java files are in the current directory and compiled against Java 17
javac -d "$TEMP_DIR" -source 17 -target 17 *.java

if [ $? -ne 0 ]; then
  echo "Compilation failed. Aborting build."
  exit 1
fi

# --- 5. Package into Executable JAR ---
echo "Creating executable JAR..."
# Creates the JAR using the compiled classes and the manifest
jar cfm "$OUT_DIR/$JAR_NAME" "$MANIFEST" -C "$TEMP_DIR" .

# --- 6. Clean Up ---
rm -rf "$TEMP_DIR"
rm -f "$MANIFEST"

echo "Build complete. JAR is at $OUT_DIR/$JAR_NAME"