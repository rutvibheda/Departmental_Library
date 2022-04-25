<?php 
	define('DB_HOST', 'localhost');
	define('DB_USER', 'root');
	define('DB_PASS', '');
	define('DB_NAME', 'dept_library');

	$conn = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
	
	if (mysqli_connect_errno()) {
		echo "Failed to connect to MySQL: " . mysqli_connect_error();
		die();
	}
	
	
	$stmt = $conn->prepare("SELECT id, domain_name, book_no, book_title,  author, publication, availability FROM books;");
	

	$stmt->execute();
	

	$stmt->bind_result($id, $domain_name, $book_no,  $book_title, $author, $publication, $availability);
	
	$book = array(); 
	
	while($stmt->fetch()){
		$temp = array();
		$temp['id'] = $id; 
		$temp['domain_name'] = $domain_name; 
                                            $temp['book_no'] = $book_no; 
		$temp['book_title'] = $book_title; 
		$temp['author'] = $author; 
                                            $temp['publication'] = $publication; 
                                            $temp['availability'] = $availability; 
		array_push($book, $temp);
	}
	
	
	echo json_encode($book);
?>