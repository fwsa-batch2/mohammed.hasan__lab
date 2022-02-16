// Pre-req goal :  on submitting a form                 completed
// goal 1 : get the values of the two input field       completed
// goal 2 : add the values of the two inputs            completed
// goal 3 : display the sum of the inputs



function submitHandler() {
  event.preventDefault(); //. to prevent the page from reloading

  const firstInput = document.getElementById("firstInput");
  const secondInput = document.getElementById("secondInput");

  console.log("firstInput is " + firstInput.value);
  console.log("secondInput is " + secondInput.value);
//Adding two elements by declaring it in parseint
  const sum = parseInt(firstInput.value) + parseInt(secondInput.value);
  console.log("Sum is = " + sum);

  const div = document.getElementById("answer");
  div.innerText = sum;
}

// subtraction

// multiplication

// division
