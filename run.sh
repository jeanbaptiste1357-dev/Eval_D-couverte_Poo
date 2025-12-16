#!/usr/bin/env bash
set -euo pipefail

echo "Compilation..."
javac -d out src/*.java

echo "Exécution..."
java -cp out Main
