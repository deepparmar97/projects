//array to store questions
var pianopartquestions = ["Which of the following has a Road Sign in picture?",
    "Which of the following has a Cat in picture?",
    "Which of the following has a Dog in picture?",
    "Which of the following has a Ship in picture?",
    "Which of the following has a Bike in picture?",
    "Which of the following has a Car in picture?",
    "Which of the following has an Aeroplane in picture?",
    "Which of the following has a Bicycle in picture?",
    "Which of the following has a Bird in picture?",
    "Which of the following has a Helicopter in picture?"];
//array to store image src
var pianopartoptions = [
["Images/road.jpg", "Images/cat.jpg", "Images/dog.jpeg", "Images/ship.jpg"],
["Images/bird.jpg", "Images/ship.jpg", "Images/dog.jpeg", "Images/cat.jpg"], ["Images/helicopter.jpg", "Images/aeroplane.jpg", "Images/dog.jpeg", "Images/bird.jpg"],
["Images/bird.jpg", "Images/ship.jpg", "Images/motorcycle.jpg", "Images/bicycle.jpg"], ["Images/bicycle.jpg", "Images/bird.jpg", "Images/motorcycle.jpg", "Images/helicopter.jpg"],
["Images/car.jpg", "Images/bird.jpg", "Images/cat.jpg", "Images/helicopter.jpg"], ["Images/helicopter.jpg", "Images/cat.jpg", "Images/dog.jpeg", "Images/aeroplane.jpg"],
["Images/dog.jpeg", "Images/ship.jpg", "Images/bicycle.jpg", "Images/bird.jpg"], ["Images/bird.jpg", "Images/bicycle.jpg", "Images/car.jpg", "Images/ship.jpg"],
["Images/ship.jpg", "Images/helicopter.jpg", "Images/cat.jpg", "Images/dog.jpeg"]
];
var questionnumber = randomnumber();

//function to load questions
function loadquestionspianopart() {
    document.getElementById("picture_question").innerHTML = pianopartquestions[questionnumber];
    document.getElementById("answer1pic").src = pianopartoptions[questionnumber][0];
    document.getElementById("answer2pic").src = pianopartoptions[questionnumber][1];
    document.getElementById("answer3pic").src = pianopartoptions[questionnumber][2];
    document.getElementById("answer4pic").src = pianopartoptions[questionnumber][3];
}

//functions to checkmark the radio button while clicking on the image
function changeradio1() {
    document.getElementById("answer1").checked = true;
}

function changeradio2() {
    document.getElementById("answer2").checked = true;
}

function changeradio3() {
    document.getElementById("answer3").checked = true;
}

function changeradio4() {
    document.getElementById("answer4").checked = true;
}

//function to generate random number
function randomnumber() {
    var num = Math.random();
    num = num.toFixed(1) * 10;
    if (num >= 0 && num <= 9) {
        return Number(num);
    } else {
        randomnumber();
    }
}
//function to validate and check the answer to the question
function validatepianopart(questionnumber) {
    var question_no = questionnumber + 1;
    switch (question_no) {
    case 1:
        {
            if (document.getElementById("answer1").checked == true) {
                alert("Congratulations ! Its A Correct answer ! You Unlocked The Piano Part");

                window.location.href = "beatsolve_drum.html";
                location.replace("beatsolve_drum.html");
            } else if (document.getElementById("answer2").checked == true || document.getElementById("answer3").checked == true || document.getElementById("answer4").checked == true) {
                alert("Inorrect answer !  Please Try Again");
                location.reload();
                //location.replace("beatsolve_drum.html");
            }
        }
        break;
    case 2:
        {
            if (document.getElementById("answer4").checked == true) {
                alert("Congratulations ! Its A Correct answer ! You Unlocked The Piano Part");

                window.location.href = "beatsolve_drum.html";
                location.replace("beatsolve_drum.html");
            } else if (document.getElementById("answer2").checked == true || document.getElementById("answer3").checked == true || document.getElementById("answer1").checked == true) {
                alert("Inorrect answer !  Please Try Again");
                location.reload();
                //location.replace("beatsolve_drum.html");
            }
        }
        break;
    case 3:
        {
            if (document.getElementById("answer3").checked == true) {
                alert("Congratulations ! Its A Correct answer ! You Unlocked The Piano Part");

                window.location.href = "beatsolve_drum.html";
                location.replace("beatsolve_drum.html");
            } else if (document.getElementById("answer2").checked == true || document.getElementById("answer1").checked == true || document.getElementById("answer4").checked == true) {
                alert("Inorrect answer !  Please Try Again");
                location.reload();
                //location.replace("beatsolve_drum.html");
            }
        }
        break;
    case 4:
        {
            if (document.getElementById("answer2").checked == true) {
                alert("Congratulations ! Its A Correct answer ! You Unlocked The Piano Part");

                window.location.href = "beatsolve_drum.html";
                location.replace("beatsolve_drum.html");
            } else if (document.getElementById("answer1").checked == true || document.getElementById("answer3").checked == true || document.getElementById("answer4").checked == true) {
                alert("Inorrect answer !  Please Try Again");
                location.reload();
                //location.replace("beatsolve_drum.html");
            }
        }
        break;
    case 5:
        {
            if (document.getElementById("answer3").checked == true) {
                alert("Congratulations ! Its A Correct answer ! You Unlocked The Piano Part");

                window.location.href = "beatsolve_drum.html";
                location.replace("beatsolve_drum.html");
            } else if (document.getElementById("answer2").checked == true || document.getElementById("answer1").checked == true || document.getElementById("answer4").checked == true) {
                alert("Inorrect answer !  Please Try Again");
                location.reload();
                //location.replace("beatsolve_drum.html");
            }
        }
        break;
    case 6:
        {
            if (document.getElementById("answer1").checked == true) {
                alert("Congratulations ! Its A Correct answer ! You Unlocked The Piano Part");

                window.location.href = "beatsolve_drum.html";
                location.replace("beatsolve_drum.html");
            } else if (document.getElementById("answer2").checked == true || document.getElementById("answer3").checked == true || document.getElementById("answer4").checked == true) {
                alert("Inorrect answer !  Please Try Again");
                location.reload();
                //location.replace("beatsolve_drum.html");
            }
        }
        break;
    case 7:
        {
            if (document.getElementById("answer4").checked == true) {
                alert("Congratulations ! Its A Correct answer ! You Unlocked The Piano Part");

                window.location.href = "beatsolve_drum.html";
                location.replace("beatsolve_drum.html");
            } else if (document.getElementById("answer2").checked == true || document.getElementById("answer3").checked == true || document.getElementById("answer1").checked == true) {
                alert("Inorrect answer !  Please Try Again");
                location.reload();
                //location.replace("beatsolve_drum.html");
            }
        }
        break;
    case 8:
        {
            if (document.getElementById("answer3").checked == true) {
                alert("Congratulations ! Its A Correct answer ! You Unlocked The Piano Part");

                window.location.href = "beatsolve_drum.html";
                location.replace("beatsolve_drum.html");
            } else if (document.getElementById("answer2").checked == true || document.getElementById("answer1").checked == true || document.getElementById("answer4").checked == true) {
                alert("Inorrect answer !  Please Try Again");
                location.reload();
                //location.replace("beatsolve_drum.html");
            }
        }
        break;
    case 9:
        {
            if (document.getElementById("answer1").checked == true) {
                alert("Congratulations ! Its A Correct answer ! You Unlocked The Piano Part");

                window.location.href = "beatsolve_drum.html";
                location.replace("beatsolve_drum.html");
            } else if (document.getElementById("answer2").checked == true || document.getElementById("answer3").checked == true || document.getElementById("answer4").checked == true) {
                alert("Inorrect answer !  Please Try Again");
                location.reload();
                //location.replace("beatsolve_drum.html");
            }
        }
        break;
    case 10:
        {
            if (document.getElementById("answer2").checked == true) {
                alert("Congratulations ! Its A Correct answer ! You Unlocked The Piano Part");

                window.location.href = "beatsolve_drum.html";
                location.replace("beatsolve_drum.html");
            } else if (document.getElementById("answer1").checked == true || document.getElementById("answer3").checked == true || document.getElementById("answer4").checked == true) {
                alert("Inorrect answer !  Please Try Again");
                location.reload();
                //location.replace("beatsolve_drum.html");
            }
        }
        break;
    default:
        location.reload();
    }
}