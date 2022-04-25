<?php
$mysqli = new mysqli("localhost","root","","college_db");
define('SALT_LENGTH', 9); 

function PwdHash($pwd, $salt = null)
{
    if ($salt === null)     {
        $salt = substr(md5(uniqid(rand(), true)), 0, SALT_LENGTH);
    }
    else     {
        $salt = substr($salt, 0, SALT_LENGTH);
    }
    return $salt . sha1($pwd . $salt);
}
$user_name = filter_input(INPUT_POST, "user_name");
$userpwd = filter_input(INPUT_POST, "pwd");

$mysql_qry = "select pwd from users where user_name like '$user_name'";
$result = mysqli_query($mysqli,$mysql_qry);
$passarray = mysqli_fetch_array($result);
$password = $passarray[0];
if($password == PwdHash($userpwd ,substr($password,0,9))){
echo "CORRECT";
}
else{
echo "WRONG";}
?>
