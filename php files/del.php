<?php
 $conn = mysqli_connect("localhost", "root", "", "dept_library");
      $book_no =$_POST["book_no"];

 $qry = "Delete from books where book_no='$book_no' ";
$result = mysqli_query($conn , $qry);
if($result)
{
echo "Deleted";
}
else
{
echo "failed";
}	
?>