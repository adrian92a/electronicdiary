function changeColor(color){
    var body = document.body;
    //var body = document.getElementsByTagName("body")[0];

    body.style.background=color;
    //document.body.style="background-color: " + color;
}

function changeColorOnClick() {
    var color = document.getElementById("color").value;
    var body = document.body;
    body.style.background=color;
}

function validateNameOrSurname(htmlElement) {
    var re = /^[A-Za-z]{2,63}$/;
    if(re.test(htmlElement.value)) {
        //usuwamy class error na tym elemencie
        htmlElement.classList.remove("error");
    } else {
        //class error powinna znajdowac sie na elemencie
        htmlElement.classList.add("error");
    }
}

function isNumberKey(htmlElement) {
	var charCode = (evt.which) ? evt.which : event.keyCode
		    if (charCode > 31 && (charCode < 48 || charCode > 57))
		        return false;
		    return true;
}

function validateEmailAddress(htmlElement) {
    if(validateEmail(htmlElement.value)){
        //usuwamy class error na tym elemencie
        htmlElement.classList.remove("error");
    } else {
        //class error powinna znajdowac sie na elemencie
        htmlElement.classList.add("error");
    }

}

function validateStreet(htmlElement) {

    if(htmlElement.value.length > 0) {
        //usuwamy class error na tym elemencie
        htmlElement.classList.remove("error");
    } else {
        //class error powinna znajdowac sie na elemencie
        htmlElement.classList.add("error");
    }

}


function validatePostalCode(htmlElement) {
    var re = /^[0-9]{2}-[0-9]{3}$/;
    if(re.test(htmlElement.value)) {
        //usuwamy class error na tym elemencie
        htmlElement.classList.remove("error");
        return true;
    } else {
        //class error powinna znajdowac sie na elemencie
        htmlElement.classList.add("error");
        return false;
    }

}

function canIsendForm() {
    //TODO sprawdz wszystkie pola
    //jezeli pola sa poprawne zwrot true jezeli nie zwroc false

    //rozwiazanie
    //1. Pobierz wszytskie elementy html typu input ktore maja klase error
    //jezeli takie sa to formularz nie moze zostac wyslan y

    //2. uruchomienie kazdej z funkcji validate na odpowiednich polach
    //i sprawdznie rezultatow
    alert("nie mozesz wysalc formularza!");
    return false;
}