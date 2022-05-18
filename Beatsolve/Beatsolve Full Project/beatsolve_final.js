function headingvariation2() {
    document.getElementById("heading").style.textShadow = "0px -10px 3px blue";
    setTimeout(headingvariation, 575);
}

function headingvariation() {
    document.getElementById("heading").style.textShadow = "0px -10px 3px red";
    setTimeout(headingvariation2, 575);
}
headingvariation();

function switchaudio() {
    if (document.getElementById("downloadlink").getAttribute("href") == "Audio/nawaftrack/master.mp3") {
        var img = document.getElementById("imgfunnny").src = "Images/jerry.gif";
        document.getElementById("audio1").pause();
        document.getElementById("audio2").pause();
        document.getElementById("audio3").pause();
        document.getElementById("audio4").pause();
        document.getElementById("audio5").play();
        document.getElementById("downloadlink").href = "Audio/divyadeeptrack/master.mp3";
    }
    else if (document.getElementById("downloadlink").getAttribute("href") == "Audio/divyadeeptrack/master.mp3") {
        document.getElementById("imgfunnny").src = "Images/spdance.gif";
        document.getElementById("audio1").pause();
        document.getElementById("audio2").play();
        document.getElementById("audio3").play();
        document.getElementById("audio4").play();
        document.getElementById("audio5").pause();
        document.getElementById("downloadlink").href = "Audio/nawaftrack/master.mp3";
    }
}

function restart() {
    location.replace("index.html");
    location.href = "index.html";
    location.replace("index.html");
}