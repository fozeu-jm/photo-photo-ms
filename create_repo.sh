#!/bin/bash

function new_git () {
    curl -X POST https://api.github.com/user/repos -u fozeu-jm:$GITHUB_API_TOKEN -d '{"name":"'$1'"}'
}

echo Hello Kaizer, what is the name of your new repository?
read reponame

new_git ${reponame}
git init
git add -A
git commit -m "initial commit"
git branch -M master
git remote add origin https://github.com/fozeu-jm/${reponame}.git
git remote set-url origin https://github.com/fozeu-jm/${reponame}.git
git push origin master