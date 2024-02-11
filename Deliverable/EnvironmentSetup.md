# Instructions for setting up the project environment
This file contains the instructions that should be followed to obtain a working environment for Retapped. 

## Installing JavaJDK 17
```
sudo add-apt-repository ppa:linuxuprising/java
sudo apt update
sudo apt install oracle-java17-installer
java -version
```

- Navigate to /home/profile directory
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
sudo apt install node js
sudo apt install npm
node -v
npm -v
```

**_NOTE_** using "-v" or "-version" in the command is used to verify installation. If a version number is not returned or you recieve some other error there was a problem with the install or the package was not installed.

- Navigate to local copy of your the github repo and perform the following commands
```
mvn clean install
mvn spring-boot:run
```

- Open browser and navigate to http://localhost:8080/hello
- Look for the word "Hello!" to appear on the webpage.
