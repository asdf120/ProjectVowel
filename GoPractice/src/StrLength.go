package main

import (
	"fmt"
	"unicode/utf8"
)

func main() {

	//문자열 길이
	s1 := "Hello"
	var s2 = "한글"

	fmt.Println(len(s1))
	fmt.Println(len(s2))
	fmt.Println(utf8.RuneCountInString(s2))

	s1 = "Hello World"
	fmt.Println(s1)

	// 문자열 연산
	s1 = "Hello"
	s2 = "Hello"
	s3 := "World"
	fmt.Println(s1 == s2)
	fmt.Println(s1 + s3)

	// Bool
	var bool1 bool = true
	bool2 := false
	fmt.Println(bool1)
	fmt.Println(bool2)
}
