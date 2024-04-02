# Instructions for setting up the project environment

This file contains the instructions that should be followed to obtain a working environment for Retapped.

**_NOTE_** Ensure that you are in your home/profile directory performing the following actions.

## Installing JavaJDK 17

```
sudo add-apt-repository ppa:linuxuprising/java
sudo apt update
sudo apt install oracle-java17-installer
java -version
```

```
sudo vim .bashrc
```

- Inside the file add the following lines to the end
  `export JAVA_HOME=/usr/lib/jvm/java-17-oracle`
  `export PATH=$JAVA_HOME/bin:$PATH`
- Exit (:wq)
- Restart terminal

## Installing Maven and NodeJS

```
sudo apt install maven
mvn -version
sudo apt install npm
npm -v

# installs NVM (Node Version Manager)
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.7/install.sh | bash
# download and install Node.js
nvm install 20
# verifies the right Node.js version is in the environment
node -v # should print `v20.12.0`
# verifies the right NPM version is in the environment
npm -v # should print `10.5.0`

npm install react-scripts
npm install react-dom
npm install web-vitals
npm audit fix
node -v


[npm i @react-google-maps/api](https://www.npmjs.com/package/@react-google-maps/api)
[npm install react-icons --save](https://www.npmjs.com/package/react-icons)
[npm install --save @chakra-ui/react](https://www.npmjs.com/package/@chakra-ui/react)

```

**_NOTE_** using "-v" or "-version" in the command is used to verify installation. If a version number is not returned or you recieve some other error there was a problem with the install or the package was not installed.

- Navigate to local copy of your the github repo and perform the following commands

- Ensure your local copy of the repo is up to date

```
git checkout main
git fetch
git pull origin
```

- Navigate to src/main/frontend

```
npm run build
serve -s build
```

- Navigate to /Retapped and Run Springboot
- Run Springboot

```
mvn clean install
mvn spring-boot:run
```

- Open the browser and navigate to http://localhost:8080

* Look for the blue react animation

- Open browser and navigate to http://localhost:8080/hello

* Look for the word "Hello!" to appear on the webpage.
