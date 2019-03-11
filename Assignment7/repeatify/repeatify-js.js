function repeatString()
{
    var inputString = document.getElementById("string").value;
    var times = document.getElementById("num").value;
    var result = "";

    for(let i=1; i<=times; i++)
    {
        result += inputString;
    }
    document.write(result);
}