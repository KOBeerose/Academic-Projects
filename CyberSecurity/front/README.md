# html5-qrcode with React
<img src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9Ii0xMS41IC0xMC4yMzE3NCAyMyAyMC40NjM0OCI+CiAgPHRpdGxlPlJlYWN0IExvZ288L3RpdGxlPgogIDxjaXJjbGUgY3g9IjAiIGN5PSIwIiByPSIyLjA1IiBmaWxsPSIjNjFkYWZiIi8+CiAgPGcgc3Ryb2tlPSIjNjFkYWZiIiBzdHJva2Utd2lkdGg9IjEiIGZpbGw9Im5vbmUiPgogICAgPGVsbGlwc2Ugcng9IjExIiByeT0iNC4yIi8+CiAgICA8ZWxsaXBzZSByeD0iMTEiIHJ5PSI0LjIiIHRyYW5zZm9ybT0icm90YXRlKDYwKSIvPgogICAgPGVsbGlwc2Ugcng9IjExIiByeT0iNC4yIiB0cmFuc2Zvcm09InJvdGF0ZSgxMjApIi8+CiAgPC9nPgo8L3N2Zz4K" width="200px"><br>
[reactjs.org](https://reactjs.org/) | `Support Level` = `Strong`

Example of using [mebjas/html5-qrcode](https://github.com/mebjas/html5-qrcode) in React project with example, source and demo.

## How to build a `React Plugin / Component` using [html5-qrcode](https://github.com/mebjas/html5-qrcode)
We shall be using React's recommendation on [Integrating with Other Libraries](https://reactjs.org/docs/integrating-with-other-libraries.html) to create a plugin for `React`.

### Download the latest library
You can download this from [Github release page](https://github.com/mebjas/html5-qrcode/releases) or [npm](https://www.npmjs.com/package/html5-qrcode). And include this in `index.html`.

```html
<script src="html5-qrcode.min.js"></script>
```

### Create a new component `Html5QrcodeScannerPlugin`
You can write a custom plugin like this (see [src/Html5QrcodePlugin.jsx](./src/Html5QrcodePlugin.jsx) for reference)

```js
// file = Html5QrcodePlugin.jsx

import { Html5QrcodeScanner } from "html5-qrcode";
import React from 'react';

const qrcodeRegionId = "html5qr-code-full-region";

class Html5QrcodePlugin extends React.Component {
    render() {
        return <div id={qrcodeRegionId} />;
    }

    componentWillUnmount() {
        // TODO(mebjas): See if there is a better way to handle
        //  promise in `componentWillUnmount`.
        this.html5QrcodeScanner.clear().catch(error => {
            console.error("Failed to clear html5QrcodeScanner. ", error);
        });
    }

    componentDidMount() {
        // Creates the configuration object for Html5QrcodeScanner.
        function createConfig(props) {
            var config = {};
            if (props.fps) {
            config.fps = props.fps;
            }
            if (props.qrbox) {
            config.qrbox = props.qrbox;
            }
            if (props.aspectRatio) {
            config.aspectRatio = props.aspectRatio;
            }
            if (props.disableFlip !== undefined) {
            config.disableFlip = props.disableFlip;
            }
            return config;
        }

        var config = createConfig(this.props);
        var verbose = this.props.verbose === true;

        // Suceess callback is required.
        if (!(this.props.qrCodeSuccessCallback )) {
            throw "qrCodeSuccessCallback is required callback.";
        }

        this.html5QrcodeScanner = new Html5QrcodeScanner(
            qrcodeRegionId, config, verbose);
        this.html5QrcodeScanner.render(
            this.props.qrCodeSuccessCallback,
            this.props.qrCodeErrorCallback);
    }
};

export default Html5QrcodePlugin;
```

### Use this new component in your React app
A very crude example would be to
```js
class App extends React.Component {
    constructor(props) {
        super(props);

        // This binding is necessary to make `this` work in the callback.
        this.onNewScanResult = this.onNewScanResult.bind(this);
    }

    render() {
        return (<div>
            <h1>Html5Qrcode React example!</h1>
            <Html5QrcodePlugin 
                fps={10}
                qrbox={250}
                disableFlip={false}
                qrCodeSuccessCallback={this.onNewScanResult}/>
        </div>);
    }

    onNewScanResult(decodedText, decodedResult) {
        // Handle the result here.
    }
);
```

### Example implementation
You can find an example implementation at [example.html](./example.html).

### Additional Contributors
| Name | Profile|
| ----- | ------ |
| Andy Tenholder| [@AndyTenholder](https://github.com/AndyTenholder) |
| Minhaz | [@mebjas](https://github.com/mebjas) |

### Credits
 - [scanapp.org](https://scanapp.org) - Free online barcode and qrcode scanner - scan directly on your web browser using camera or images saved on your device. Works well on smart phones as well as PC or Mac.
