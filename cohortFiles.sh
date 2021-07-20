# USAGE
# in the terminal type: bash cohortFiles.sh

# TIPS
# On a Mac: after running, command+doubleClick to open a link
# If you wanted, you could also change `echo` to `open` (down below) to automatically open all tabs

# pathToFile
# example: meth1/01_lesson.md
# example: ds/sort1/SortDemo.java
slug="meth1/01_lesson.md"

users=(
mrbombmusic # Liam
Vmiller77 # Victoria
MichCS # Michelle B
JCardenas62 # Jovani
lfridman2016 # Lyuba
chaouiki1 # Mr H
irimina # Julian
Skabanakis # Steph
jkimbxv # Jiyoon
mlaks23 # Marisa
Leiteduardo # Eduardo
leungbenson # Benson
Dwayneglevene # Dwayne
tyl3452 # Eric L
alexmoore77 # Alex
Marina_M # Marina
brianmueller # Brian
daianam08 # Daiana
cobrien-teach # Chris
learncs0 # Michele P
ischeff # Ian
petertsun # Peter
mamudu # Mamudu
wilsoneg3 # Eric W
onlinecsteacher # Emma
twong-cs # Tiffany
)

for user in "${users[@]}"
do
  url="https://github.com/hunter-teacher-cert/work_csci70900-${user}/blob/master/${slug}"

  # print all URLs (some may need modification)
  # echo $url

  # print ONLY the URLs that are valid
  # https://stackoverflow.com/questions/12199059/how-to-check-if-an-url-exists-with-the-shell-and-probably-curl
  if curl --output /dev/null --silent --head --fail "$url"; then
    echo $url
  # else
    # echo "URL does not exist: $url"
  fi
done
