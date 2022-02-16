// function definition/declaration
function myFunction() {
    console.log("inside the function");
  }
  
  // invoke a function or calling a function
  // without parenthesis it will be registered as a variable
  myFunction();
  
  // ! =====================================================================================================
  
  // declaration of a function
  // params is short for Parameters
  
  function printSomeName(someName) {
    console.log(someName);
  }
  
  // Invoking a function
  printSomeName();
  // output is Undefined
  
  // this way is not recommended
  printSomeName("Ismail");
  
  // * the recommended way
  var username = "Surya";
  printSomeName(username);
  
  // ! =======================================================================================================
  
  // pass two input(parameter)
  // console.log the sum of two numbers
  
  function adding(number1, number2) {
    const sum = number1 + number2;
    console.log(sum);
  }
  
  const input1 = 10;
  const input2 = 43;
  
  adding(input1, input2);
  
  // ! =======================================================================================================
  
  // pass two inputs
  // return the difference of two number
  
  // Definition/Declaration
  function subtraction(number1, number2) {
    const difference = number1 - number2;
    // the key work return is to send a output;
    return difference;
  }
  
  const input3 = 0;
  const input4 = 10;
  
  const diff = subtraction(input3, input4);
  
  console.log("diff is = " + diff);
  
  // ! =================================================================================================
  