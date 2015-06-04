runner {
    if (!System.getProperty("CI")) {
        exclude Slow
    }
}
