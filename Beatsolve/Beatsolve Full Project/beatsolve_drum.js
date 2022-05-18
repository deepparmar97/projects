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
///////GLOBAL VARIABLES
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
    ["What is Tempo?", // Q1
        "The pace of the song", //A
        "The repeated sequences of a song", //B
        "The notes in a song", //C
        "The volume of the song", //D
        "A"], //Answer
    //
    ["What do you use to calculate<br> the speed of a song?", // Q2
        "Metronome", //A
        "Guessing", //B
        "Playing an instrument", //C
        "Asking a instructor", //D
        "A"], //Answer
    //
    ["What is the level and <br>intensity of sound measured in?", // Q3
        "Sound level meter", //A
        "Decibels", //B
        "Frequency", //C
        "Distance", //D
        "B"], //Answer
    //
    ["What do we call the section of the song with the<br> same lyrics and the same melody every-time?", //Q4
        "Bridge", //A
        "Solo", //B
        "Introduction", //C
        "Chorus", //D
        "D"], //Answer
    //
    ["What is harmony in music?", //Q5
        "The strong, regular, repeated pattern of movement or sound", //A
        "The combination of simultaneously sounded musical notes<br> to produce chords and chord progressions having a pleasing effect", //B
        "A sequence of single notes that is musically satisfying", //C
        "The character or quality of a musical sound <br>or voice as distinct from its pitch and intensity", //D
        "B"] //Answer
    //
];
///////QUESTIONS IN ARRAY FORM

function get(x) {
    "use strict";
    return document.getElementById(x);
}
//
function renderQuestion() {
    "use strict";
    test = get("test");
    if (pos >= questions.length) {
        //
        pos = 0;
        correct = 0;
        //
        return false;
    }

    ///
    get("test_status").innerHTML = "Question " + (pos + 1) + " of " + questions.length + "<br>";
    question = questions[pos][0];
    chA = questions[pos][1];
    chB = questions[pos][2];
    chC = questions[pos][3];
    chD = questions[pos][4];
    test.innerHTML = "<br><h3>" + question + "</h3>";
    //
    test.innerHTML += "<br><input type='radio' name='choices' value='A'> " + chA + "<br><br>";
    //
    test.innerHTML += "<input type='radio' name='choices' value='B'> " + chB + "<br><br>";
    //
    test.innerHTML += "<input type='radio' name='choices' value='C'> " + chC + "<br><br>";
    //
    test.innerHTML += "<input type='radio' name='choices' value='D'> " + chD + "<br><br>";
}
///
function checkAnswer() {
    "use strict";
    var i;
    choices = document.getElementsByName("choices");
    for (i = 0; i < choices.length; i += 1) {
        if (choices[i].checked) {
            choice = choices[i].value;
        }
    }
    //
    if (choice === questions[pos][5]) {
        correct += 1;
    }

    //
    pos += 1;
    if (correct !== 5 && pos === 5) {
        window.alert(test.innerHTML = "You got " + correct + " of " + questions.length + " questions correct! Please try again to unlock the next stage.");
        renderQuestion(false);
    } else if (correct === 5) {
        window.alert("You got " + correct + " of " + questions.length + " questions correct! Nice work, advance to the next level");
        alert("Congratulations !! You Unlocked The Drum Part");
        location.replace("beatsolve_bass.html");
        window.location.href = "beatsolve_bass.html";
        location.replace("beatsolve_bass.html");
    }
    renderQuestion();
}
window.addEventListener("load", renderQuestion, false);