name="${1%.java}"
file="${name//./\/}.java"

. ../process.sh

orig="$JAVA/${file}"
target="./${file}"

mkdir -p $(dirname "${target}")
cp -v "${orig}" "${target}"
./cleanup.sh "${target}"
git add "${target}"
