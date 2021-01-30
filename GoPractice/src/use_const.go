package main

import "fmt"

func main() {
	// 상수
	//const a = 10
	//const b = 20
	//var c int
	//c = 30
	//fmt.Println(a)
	//fmt.Println(c)

	// 열거형 사용
	const (
		a = iota	// 0부터 순서대로 값 저장
		b
		c
		d
		e
	)
	fmt.Println(c)
	fmt.Println(e)
}
