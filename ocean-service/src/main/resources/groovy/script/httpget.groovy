def testHttpRequest(url) {
    def connection = new URL(url).openConnection()
    connection.setRequestMethod('GET')
    connection.doOutput = true


    def writer = new OutputStreamWriter(connection.outputStream)
    writer.flush()
    writer.close()
    connection.connect()


    return connection.getContentLength()
}