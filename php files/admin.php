<?php
$mysqli = new mysqli("localhost","root","","dept_library");
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
$user_id = filter_input(INPUT_POST, "user_id");
$userpwd = filter_input(INPUT_POST, "password");

$mysql_qry = "select password from books_librarian where user_id like '$user_id'";
$result = mysqli_query($mysqli,$mysql_qry);
$passarray = mysqli_fetch_array($result);
$password = $passarray[0];
if($password == PwdHash($userpwd ,substr($password,0,9))){
echo "CORRECT";
}
else{
echo "WRONG";}
?>
