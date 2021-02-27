#!/bin/sh
printf "abaaba\nababa\nabbbabbb\nabbaabb" > test
printf "test:"
cat test
printf "\ngrep '^\(.*\)\1$' test\n"
grep '^\(.*\)\1$' test
