<?php

$smart_card_no=filter_input(INPUT_POST, "smart_card_no");
$registration_no=filter_input(INPUT_POST, "registration_no");

$mysqli = new mysqli("localhost","root","","college_db");

$result=mysqli_query($mysqli,"select * from student_table2 where smart_card_no='$smart_card_no' and registration_no='$registration_no'");

if(mysqli_fetch_array($result)){

	echo '1';
}

?>