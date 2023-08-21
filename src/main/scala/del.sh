#!/bin/bash
for i in $(seq 10000); do
    cat file.csv >> file_out.csv
    if [[ $((i % 1000)) == 0 ]]; then
        echo "$i"
    fi
done