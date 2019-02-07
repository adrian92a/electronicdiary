 function calc(){
    var param1 = document.getElementById("param1").value;
    var param2 = document.getElementById("param2").value;
    var operation = document.getElementById("operation").value;

    var result = 0;
//    switch(operation) {
//      case "+":
//        result = +param1 + +param2;
//        break;
//      case "-":
//        result = param1 - param2;
//        break;
//      case "*":
//        result = param1 * param2;
//      break;
//        case "/":
//        result = param1 / param2;
//      break;
//    }
    result = eval(param1 + operation + param2);
    document.getElementById("result").innerHTML = result;
 }