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

 $qry = "INSERT INTO books (domain_no,domain_name,book_no,book_title,author,publication,donated_by,availability,deleted,user_name,user_name2) VALUES ('$domain_no','$domain_name','$book_no','$book_title','$author','$publication','$donated_by','$availability','$deleted','$user_name','$user_name2')";
$result = mysqli_query($conn , $qry);
if($result)
{
echo "Inserted";
}
else
{
echo "failed";
}	
?>