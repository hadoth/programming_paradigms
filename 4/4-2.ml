type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;

let tt = Node(1,
	Node(2,
		Node(4,
			Empty,
			Empty
		),
		Empty
	),
	Node(3,
		Node(5,
			Empty,
			Node(6,
				Empty,
				Empty
			)
		),
		Empty
	)
);;


let rec longestRoute node = 
	match node with 
		Empty -> (0, []) |
		Node(elem, left, right) -> 
			let (lenLeft, searchLeft) = longestRoute left in
			let (lenRight, searchRight) = longestRoute right in
			if lenLeft >=  lenRight
				then ((lenLeft + 1), (elem::searchLeft))
				else ((lenRight + 1), (elem::searchRight));;
				
let longest tree = let (len, list) = longestRoute tree in list;;

longestRoute tt;;
longest tt;;
