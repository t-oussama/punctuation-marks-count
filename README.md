# punctuation-marks-count
### This project is a technical test offered by CodeOnce.

## Quick start Guide
1. Clone the repository
```
git clone https://github.com/t-oussama/punctuation-marks-count.git
```

2. Start the `spring boot Rest API`:
```
cd api
mvn spring-boot:run
```

3. Use `Swagger` to make sure the API is up and running: http://localhost:8080/swagger-ui.html .

4. Install dependencies and run the `Angular 8` app:
```
cd front-end
npm i
ng serve
```

5. Test the app at http://localhost:4200

=======================

## The Characters Calculation Service's approach explanation:

When implementing the punctuation markers count service, our first instinct was to simply loop through the text one character at a time and then verify, for each character, if it is part of the characters we are interested in counting, which in turn translates to an other loop.

So eventually, we would have a cost of **2N x P** instructions, where **N** is the number of characters in the text and **P** is the number of characters we are interested in counting.

However, with the method we implemented, we would sacrifice in RAM usage optimisation by allocation a HashMap containing one entry for each unique character in the text, and win on the other hand on CPU usage as we would have **4N + 2P** instructions.

For e.g, with:
N = 100
P = 6
The first approache's cost is: **1200**
The second approache's cost is: **412**

###Note: Please read the  code to have a better understanding of what this section covers

