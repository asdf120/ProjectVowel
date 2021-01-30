package main

import "fmt"

/*
이렇게 주석
*/

//주석
//TODO 이건 투두
func main() {
	var s1 string = "Hello World"

	var s2 string = `안녕하세요
Hello World`
	//fmt.Println(s1)
	fmt.Println(s1 + "\n" + s2)
}
