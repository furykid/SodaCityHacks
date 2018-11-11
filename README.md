## Project Title
Second Tier Key Authentication (STKA)

## What is the project about?
STKA assumes a secure closed network with n devices. It takes a single network key, parses it and scrambles which parsed piece of the key to put on each of the n devices.  This would require intruders to access ALL devices on the network in order to obtain the full key to infiltrate the secured system.  

## What technologies are used?
The technologies used for STKA include **AWS's lambda function** (written in **Java**) by way of an **api gateway** which is called through a **http get request** and returns a randomly generated key.  The randomly generated key is then parsed into n different parts or devices on the network. For our demo, n = 3.  

We also utilized a team member built android app that generates gps coordinates to create our target secured area. When a device leaves the predefined secure area it triggers rerunning of the algorithm.  For demo purposes we also utilized **IBM's Cloud Platform** and **Node.Red** to allow for connections of the components in the **GrovePi's** starter kit. These components include an led rgb backlight, buzzer and individual colored led lights (red, green and blue) to show which devices trigger the rerunning of the algorithm and re-parsing of the key. 

## What challenges did we run into?
The biggest challenge or time drain was on getting **GrovePi** and **Node.Red** talking to each other and getting the code right to trigger the **GrovePi starter kit** components to work. We also had to come together multiple times to solidify our project plans and make sure we were all on the same page with flow and purpose of the data created and collected.  

## What accomplishments that we're proud of and what we learned?
We are proud of the execution of the project plan and the team work needed to fully execute it.  Most of the technologies that we utilized have been new to most of the team members and took a great deal of learning. To get all of the technologies to talk to each other was an accomplishment we are proud of. 

## What's next for STKA?
There are three things we would consider next steps for STKA.  For the parsing of the key we would like to utilize multiple algorithms to decide the parsing of the data. These algorithms could include multiple **graph theory** and **network algorithms** such as **Round Robin**.  We would also like to randomize the timing for each device to re-trigger the algorithm instead of utilizing the gps trigger.  Finally we would like to look into what could be done if we had an open network instead of a secured network.  How could we apply the algorithm and what efficiencies could be gained if a new device was added or taken out of the network. 

