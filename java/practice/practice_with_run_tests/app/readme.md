### By Mariya Al Nasrala (ma227ji)

## Report

I began by working with the Practice_with_run_tests project to test various bugs related to password handling. I utilized Java as the programming language along with the JUnit testing framework to write and run unit tests. Additionally, I used the jaCoCo tool to measure test coverage.


- **Features** i tested in the passwords:
1. Passwords must be **trimmed**.
2. Passwords must have a **minimum length**.
3. Passwords ahould not be **empty**.


## Password Test
✅ ❌

| Testname       | *Correct* | *Not Trim*| *To Short* | *Very short* | *Missing Num check* | *P Always same* | *Hash* | *Missing length check* | *Wrong Exception message* |
|---|---|---|---|---|---|---|---|---|---|
|Trim password|✅|❌|✅ |✅ |✅ |✅ |✅ |✅ |✅ |
|Empty Password |✅|✅|✅|✅|✅|✅|✅|✅|✅|
|Too Short password|✅|✅|❌|❌|✅|✅|✅|✅|✅|
|very short Password|---|---|---|---|---|---|---|---|---|
|Hash|---|---|---|---|---|---|---|---|---|
|With numbers|---|---|---|---|---|---|---|---|---|
|Without numbers|---|---|---|---|---|---|---|---|---|
|Same always|---|---|---|---|---|---|---|---|---|
|Coverage|---|---|---|---|---|---|---|---|---|
