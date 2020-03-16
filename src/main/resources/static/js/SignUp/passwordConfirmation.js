 // function checkEqualityOfPassword() {
 //    if (document.getElementById('password').value == document.getElementById('confirmPassword').value)
 //    {
 //        document.getElementById('submit').disabled = false
 //    } else {
 //        document.getElementById('submit').disbled = true
 //    }
 // }

 checkEqualityOfPassword();

 $('#password, #confirmPassword').on('keyup', function () {
     if ($('#password').val() == $('#confirmPassword').val()) {
         document.getElementById('submit').disabled =false
     } else {
         document.getElementById('submit').disabled = true
     }
 })