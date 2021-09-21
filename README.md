# Wildlife Tracker
#### Wildlife Tracker, April 28th 2019
#### By **Peter Wachira**
![](screenshots/screenshot1.png)
![]()
## Description

```bash
An application that allows Rangers to track wildlife sightings in the area.
```

## TOC

- [Installation](#Installation)
- [SQL](#SQL)
- [Tests](#Tests)
- [Live Demo](#Tests)
- [Requirements](#Requirements)
- [Known Bugs](#Requirements)
- [Extras](#extras)



## Technologies Used
[![forthebadge](https://forthebadge.com/images/badges/powered-by-electricity.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/uses-html.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/uses-css.svg)](https://forthebadge.com)

## Installation
* `git clone <https://github.com/peter-wachira/WildlifeTracker.git>` this repository
* `cd WildlifeTracker`


## Live Demo
To view the page click on the link below
 [https://gentle-fortress-49119.herokuapp.com/](*)

## Tests

- To run test, run files under tests/java package 


## SQL
```bash
1.Launch postgres

2.Type in psql

Run these commands

3. CREATE DATABASE wildlife_tracker;

4. \c wildlife_tracker;

5. CREATE TABLE animals (id serial PRIMARY KEY, name varchar, health varchar, age varchar, type varchar);

6. CREATE TABLE wildlife_tracker=# CREATE TABLE sightings (id serial PRIMARY KEY, animal_id int, location varchar, ranger_name varchar, timestamp timestamp);

7. CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;

```
## Requirements
```bash
The applications allow users to do the following:

1.Add a new animal
 
2.Add an endangered animal

3.Add an animal Sighting

```

## Known Bugs
- Quick note that The page loads a bit slow due to the hosting, kindly be a little patient everything works just fine.
- There are currently no tests done for this project.
- As at the time this project was made, responsiveness was not a major concern 
- The project is currently not being maintained any more 
- Thanks for understanding.



## Contact Details
```bash
You can contact me at pwachira900@gmail.com
```

## License
- This project is licensed under the MIT Open Source license Copyright (c) 2019. [LICENCE](https://github.com/peter-wachira/WildlifeTracker/blob/master/LICENCE)

[![forthebadge](https://forthebadge.com/images/badges/makes-people-smile.svg)](https://forthebadge.com)
