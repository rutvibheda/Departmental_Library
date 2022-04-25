<?php
    $conn = mysqli_connect("localhost", "root", "", "dept_library");
    $domain_no =$_POST["domain_no"];
    $domain_name = $_POST["domain_name"];
      $book_no =$_POST["book_no"];
    $book_title = $_POST["book_title"];
     $author =$_POST["author"];
    $publication = $_POST["publication"];
     $donated_by=$_POST["donated_by"];
    $availability = $_POST["availability"];
    $deleted =$_POST["deleted"];
    $user_name = $_POST["user_name"];
  $user_name2 =$_POST["user_name2"];

 $qry = "update books set domain_no='$domain_no',domain_name='$domain_name',book_no='$book_no',book_title='$book_title',author='$author',publication='$publication',donated_by='$donated_by',availability='$availability',deleted='$deleted',user_name='$user_name',user_name2='$user_name2' where book_no='$book_no' ";
$result = mysqli_query($conn , $qry);
if($result)
{
echo "Updated";
}
else
{
echo "failed";
}	
?>