pub fn fib(n: i32) -> i32 {
    static mut MAP: Option<HashMap<i32, i32>> = None;
    unsafe {
        if MAP.is_none() {
            MAP = Some(HashMap::new());
        }
    }
    let map = unsafe { MAP.as_mut().unwrap() };

    if n < 1 {
        return 0;
    }
    if n == 2 || n == 1 {
        return 1;
    }
    if map.contains_key(&n) {
        return match map.get(&n) {
            Some(x) => *x,
            _ => 0,
        }
    }
    if !map.contains_key(&n) {
        let mut tmp: i32 = Solution::fib(n - 1) + Solution::fib(n - 2);
        map.insert(n, tmp);
    } 
    return match map.get(&n) {
        Some(x) => *x,
        _ => 0,
    } 
}