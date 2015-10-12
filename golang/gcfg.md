# gcfg - A Go library that reads text-based configuration files

## Introduction

Gcfg is a Go library that reads text-based configuration files that consist of "name=value" pairs grouped into sections.
The syntax is similar to the INI-style formats that have been in user for a long itme.
Specifically, the syntax is based on gitconfig, with minor change.
Gcfg reads configuration data into a POGS (Plain Old Go Structs).
Gcfg also supports user-defined types and subsections.

Here is an example of gcfg file:

```
; Comment line
[section]
name = value # Another comment
flag # implicit value for bool is true
```

The corresponding Go struct is:

```
type Config struct {
    Section struct {
        Name string
        Flag bool
    }
}
```

To read a file into a struct:

```
var cfg Config
err := gcfg.ReadFileInto(&cfg, "myconfig.gcfg")
```

See the package documentation for usage details and more examples.

The recommended file extension for gcfg files is .gcfg .

## Where to start?
To install the library, run

```
go get code.google.com/p/gcfg
```

To update to the most recent version, run

```
go get -u code.google.com/p/gcfg
```

## See Also

[gcfg](https://code.google.com/p/gcfg/)
read INI-style configuration files into Go structs; supports user-defined types and subsections.
