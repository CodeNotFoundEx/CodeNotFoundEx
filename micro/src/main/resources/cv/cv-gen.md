brew install pandoc
brew install --cask basictex
export PATH="/Library/TeX/texbin:$PATH"
pandoc cv.md -o cv.pdf