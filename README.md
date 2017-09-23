# ArduBlock


ArduBlock is a Block Programming Language for Arduino. The language and functions model closely to [Arduino Language Reference](http://arduino.cc/en/Reference/HomePage)

## Users
Ardublock is a free graphical programming environment to make programming physical computing with Arduino as easy as drag and drop. It is based on the popular ‘scratch’ programming language, which many will already be familiar with.  Ardublock generates code in C, a text based language used by the Arduino IDE, which can then be studied and modified if desired. 

Ardublock is an extension to the Arduino IDE so that will need to be downloaded as well (found here https://www.arduino.cc/en/Main/Software).  
* Ardublock is tested with version 1.8.2, available here: https://www.arduino.cc/download_handler.php?f=/arduino-1.8.2-windows.exe

Code written in Ardublock has the file extension .abp.

#### Getting Started with ArduBlock
1. Install the Arduino IDE, from https://www.arduino.cc/en/Main/Software
2. Download ardublock-all.jar https://github.com/stfc/ardublock/releases/latest
3. Copy ardublock-all.jar to C:/Users/<username>/Arduino/tools/ArduBlockTool/tool/ardublock-all.jar under
    * Be careful, the name of folder “ArduBlockTool” under tools folder is case sensitive. 
    * In Mac, /Users/<username>/Documents/Arduino/tools/ArduBlockTool/tool/ardublock-all.jar
    * In Linux, /home/<username>/sketchbook/tools/ArduBlockTool/tool/ardublock-all.jar
4. Start the Arduino IDE and find ArduBlock under the Tool menu

## Developers
If you wish to develop ardublock, follow the instructions below. A prerequsite is openblocks, which can be found here https://github.com/gregcorbett/openblocks
### Installation

The project is managed by Maven. After checking out the source for the first time, one should run the following to install Arduino's pde.jar into the local repository. 

	$ mvn validate

### Usage

	$ mvn exec:java -Dexec.mainClass="com.ardublock.Main"

### Development

Change the /src/main/resources/com/ardublock/block/ardublock_def.xml to add new blocks to ArduBlock

	$ mvn clean package

	$ mvn compile exec:java -Dexec.mainClass="com.ardublock.Main"

The Visual Block environment should show up. Happy Hacking! ;) 

### Deploy

Edit code of ardublock

	$ mvn clean package

copy the target/ardublock-all.jar to Arduino\tools\ArduBlockTool\tool

## Authors

The original code (https://github.com/taweili/ardublock) was developed at MIT and the authors can be contacted below.

* David Li taweili@gmail.com
* HE Qichen heqichen@gmail.com

The author/maintainer of this fork can be contacted at greg.corbett@stfc.ac.uk.

## License
Copyright (C) 2011 David Li and He Qichen

This file is part of ArduBlock.

ArduBlock is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

ArduBlock is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with ArduBlock.  If not, see <http://www.gnu.org/licenses/>.
