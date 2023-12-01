use rand::Rng;
use std::{cmp::Ordering, io};

pub fn data_types() {
    // convert String to numeric types
    let guess: i32 = "42 ".trim().parse().expect("Not a number!!");
    println!("guess: {}", guess);
}

pub fn variables_and_mutability() {
    // add 'mut' to be mutable
    let mut a = 12;
    println!("The value of x is: {a}");
    a = 5;
    println!("The value of x is: {a}");

    // shadowing
    let x = 5;
    let x = x + 1;
    {
        let x = x * 2;
        println!("1. Inner scope value: {x}")
    }
    println!("2. x value: {x}");

    let spaces = "   ";
    let spaces: i32 = spaces.len().try_into().unwrap();
    println!("spaces variable len: {spaces}")
}

pub fn guess_the_number() {
    println!("Guess the number!");
    let secret_number = rand::thread_rng().gen_range(1..=100);
    loop {
        println!("Please input your guess.");
        let mut guess = String::new();
        io::stdin()
            .read_line(&mut guess)
            .expect("Failed to read line");
        let guess: u32 = match guess.trim().parse() {
            Ok(num) => num,
            Err(_) => continue,
        };
        println!("You guessed: {guess}");
        match guess.cmp(&secret_number) {
            Ordering::Less => println!("Too small"),
            Ordering::Greater => println!("Too big"),
            Ordering::Equal => {
                println!("You win!");
                break;
            }
        }
    }
}
