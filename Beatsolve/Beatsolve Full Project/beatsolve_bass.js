// pos is position of where the user in the test or which question they're up to
var pos = 0,
    test,
    test_status,
    question,
    choice,
    choices,
    chA,
    chB,
    chC,
    chD,
    correct = 0;

function headingvariation2() {
    document.getElementById("heading").style.textShadow = "0px -10px 3px blue";
    setTimeout(headingvariation, 575);
}

function headingvariation() {
    document.getElementById("heading").style.textShadow = "0px -10px 3px red";
    setTimeout(headingvariation2, 575);
}
headingvariation();
var questions = [
    ["Why do JavaScript and Java <br>have similar names?", // question 1
        "Javascript is a stripped-down version of Java", //A
        "JavaScript's syntax is loosely based on Java's", //B
        "They both orginated on the island of Java", //C
        "The creators loved coffee", //D
        "B"],

    ["What are variables used for<br> in JavaScript programs?", //question 2
        "Storing numbers, dates or other values", //A
        "Varying randomnly", //B
        "Causing high-school alegbra flashbacks", //C
        "Creating variation in a function", //D
        "A"],

    ["What is the correct JavaScript syntax<br> to write 'Hello World'?", //question 3
        "System.out.println('Hello World')", //A
        "write.me'Hello World'", //B
        "document.write('Hello World')", //C 
        "response.write('Hello World')", //D
        "C"],

    ["Inside which HTML element do we<br> put the JavaScript", //question 4
        "< script >", //A
        "< js >", //B
        "< javascript >", //C
        "< dothing >", //D
        "A"],

    ["How does JavaScript store dates in a date object?", //question 5
        "The number of milliseconds since January 1st, 1970", //A
        "The number of seconds since the earth's first rotation", //B
        "It looks at a clock", //C
        "Number of days since January 1st, 1899", //D
        "A"]
];

// this get function is short for the getElementById function  
function get(x) {
    "use strict";
    return document.getElementById(x);
}

function renderQuestion() {
    "use strict";
    test = get("test");
    if (pos >= questions.length) {
        // resets the variable to allow users to restart the test
        pos = 0;
        correct = 0;
        // stops rest of renderQuestion function running when test is completed
        return false;
    }
    get("test_status").innerHTML = "Question " + (pos + 1) + " of " + questions.length + "<br>";
    question = questions[pos][0];
    chA = questions[pos][1];
    chB = questions[pos][2];
    chC = questions[pos][3];
    chD = questions[pos][4];
    test.innerHTML = "<br><h3>" + question + "</h3>";
    // the += appends to the data we started on the line above
    test.innerHTML += "<br><input type='radio' name='choices' value='A'> " + chA + "<br><br>";
    test.innerHTML += "<input type='radio' name='choices' value='B'> " + chB + "<br><br>";
    test.innerHTML += "<input type='radio' name='choices' value='C'> " + chC + "<br><br>";
    test.innerHTML += "<input type='radio' name='choices' value='D'> " + chD + "<br><br>";

}

function checkAnswer() {
    "use strict";
    // use getElementsByName because we have an array which it will loop through
    var i;
    choices = document.getElementsByName("choices");
    for (i = 0; i < choices.length; i += 1) {
        if (choices[i].checked) {
            choice = choices[i].value;
        }
    }
    // checks if answer matches the correct choice
    if (choice === questions[pos][5]) {
        //each time there is a correct answer this value increases
        correct += 1;
    }
    // changes position of which character user is on
    pos += 1;
    if (correct !== 5 && pos === 5) {
        window.alert(test.innerHTML = "You got " + correct + " of " + questions.length + " questions correct! Try again!");
        renderQuestion(false);
    } else if (correct === 5) {
        window.alert("You got " + correct + " of " + questions.length + " questions correct! Nice Work!");

        ////////////////////////////////////////////////////////////////////////////////////////
        /////add here what you want beatsolve to do once the quiz is completed successfully/////
        ////////////////////////////////////////////////////////////////////////////////////////
        alert("Congratulations !! You Unlocked The Bass Part");
        location.replace("beatsolve_final.html");
        window.location.href = "beatsolve_final.html";
        location.replace("beatsolve_final.html"); // when the user reaches 5 correct questions, they are able to move on to next portion of beatsolve

    }
    // then the renderQuestion function runs again to go to next question
    renderQuestion();

}

window.addEventListener("load", renderQuestion, false);