# The decompiled java typically includes a number of features that are not compatible with the ancient class version needed on the MIB2 (1.2)
# This script is used to clean up these features (where possible).

shopt -s globstar nullglob

FILE=$1

cleanup_java() {
  echo "Cleanup $1"
  sed -i 's: final : /*final*/ :g' $1
  sed -r -i 's:  @Override: // @Override:g' $1
  perl -0777 -npi -e 's:    default (.*)\{\n    \}:    /*default*/ \1;:g' $1
}

if [ -z "$FILE" ]; then
  #find ./ \( -type d -name .git -prune \) -o -type f -name '*.java' -print0 | xargs -0 
  for j in ./**/*.java; do 
    cleanup_java $j
  done
else
  cleanup_java $FILE
fi
