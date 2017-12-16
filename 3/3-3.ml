type intOrFloat = Int of int | Float of float;;

let rec different (list: intOrFloat list) = match list with [] -> true | (Int i1)::(Int i2)::_ -> false | (Float f1)::(Float f2)::_ -> false | _::tail -> (different tail);;

different [Int 9; Float 8.1; Int 7; Float 6.0; Int 5; Float 0.2];;
