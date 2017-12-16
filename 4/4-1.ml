type eval = Num of float | Neg | Add | Sub | Mul | Div;;

let rec evalIt list = 
	match list with 
		[] -> raise (Failure "Insufficient number of arguments") |
		h::t -> match h with 
			Num n -> (n, t) |
			Neg -> let (first, rest) = evalIt t in (-.first, rest) |
			Add -> let (first, rest) = evalIt t in let (second, rest2) = evalIt rest in (first +. second, rest2) |
			Sub -> let (first, rest) = evalIt t in let (second, rest2) = evalIt rest in (first -. second, rest2) |
			Mul -> let (first, rest) = evalIt t in let (second, rest2) = evalIt rest in (first *. second, rest2) |
			Div -> let (first, rest) = evalIt t in let (second, rest2) = evalIt rest in (first /. second, rest2);;

let eval list = let (result, rest) = evalIt (List.rev list) in result;;

eval [Num 5.0; Num 2.0; Add];;
eval [Num 5.0; Num 2.0; Add; Num 2.0; Add];;
eval [Num 5.0; Num 2.0; Add; Add];;
