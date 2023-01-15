const inputsDate = document.querySelectorAll('input[type="date"]')
for(input of inputsDate){
    let dateString = input.getAttribute('value')
    input.setAttribute('value', dateString.slice(0,10))
}
