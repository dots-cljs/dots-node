(ns dots.fs.read-stream
  "Instances of `fs.ReadStream` are created and returned using the {@link createReadStream } function.")

(defn close
  (^js [read-stream]
   (.close ^js read-stream))
  (^js [read-stream callback]
   (.close ^js read-stream callback)))

(defn bytes-read
  "The number of bytes that have been read so far."
  ^js [read-stream]
  (.-bytesRead ^js read-stream))

(defn set-bytes-read!
  "The number of bytes that have been read so far."
  ^js [read-stream value]
  (set! (.-bytesRead ^js read-stream) value))

(defn path
  "The path to the file the stream is reading from as specified in the first
   argument to `fs.createReadStream()`. If `path` is passed as a string, then`readStream.path` will be a string. If `path` is passed as a `Buffer`, then`readStream.path` will be a
   `Buffer`. If `fd` is specified, then`readStream.path` will be `undefined`."
  ^js [read-stream]
  (.-path ^js read-stream))

(defn set-path!
  "The path to the file the stream is reading from as specified in the first
   argument to `fs.createReadStream()`. If `path` is passed as a string, then`readStream.path` will be a string. If `path` is passed as a `Buffer`, then`readStream.path` will be a
   `Buffer`. If `fd` is specified, then`readStream.path` will be `undefined`."
  ^js [read-stream value]
  (set! (.-path ^js read-stream) value))

(defn pending?
  "This property is `true` if the underlying file has not been opened yet,
   i.e. before the `'ready'` event is emitted."
  ^js [read-stream]
  (.-pending ^js read-stream))

(defn set-pending!
  "This property is `true` if the underlying file has not been opened yet,
   i.e. before the `'ready'` event is emitted."
  ^js [read-stream value]
  (set! (.-pending ^js read-stream) value))

(defn add-listener
  "events.EventEmitter
     1. open
     2. close
     3. ready"
  ^js [read-stream event listener]
  (.addListener ^js read-stream event listener))

(defn on
  ^js [read-stream event listener]
  (.on ^js read-stream event listener))

(defn once
  ^js [read-stream event listener]
  (.once ^js read-stream event listener))

(defn prepend-listener
  ^js [read-stream event listener]
  (.prependListener ^js read-stream event listener))

(defn prepend-once-listener
  ^js [read-stream event listener]
  (.prependOnceListener ^js read-stream event listener))

(defn readable-aborted?
  "Returns whether the stream was destroyed or errored before emitting `'end'`."
  ^js [read-stream]
  (.-readableAborted ^js read-stream))

(defn readable?
  "Is `true` if it is safe to call `readable.read()`, which means
   the stream has not been destroyed or emitted `'error'` or `'end'`."
  ^js [read-stream]
  (.-readable ^js read-stream))

(defn set-readable!
  "Is `true` if it is safe to call `readable.read()`, which means
   the stream has not been destroyed or emitted `'error'` or `'end'`."
  ^js [read-stream value]
  (set! (.-readable ^js read-stream) value))

(defn readable-did-read?
  "Returns whether `'data'` has been emitted."
  ^js [read-stream]
  (.-readableDidRead ^js read-stream))

(defn readable-encoding
  "Getter for the property `encoding` of a given `Readable` stream. The `encoding`property can be set using the `readable.setEncoding()` method."
  ^js [read-stream]
  (.-readableEncoding ^js read-stream))

(defn readable-ended?
  "Becomes `true` when `'end'` event is emitted."
  ^js [read-stream]
  (.-readableEnded ^js read-stream))

(defn readable-flowing?
  "This property reflects the current state of a `Readable` stream as described
   in the `Three states` section."
  ^js [read-stream]
  (.-readableFlowing ^js read-stream))

(defn readable-high-water-mark
  "Returns the value of `highWaterMark` passed when creating this `Readable`."
  ^js [read-stream]
  (.-readableHighWaterMark ^js read-stream))

(defn readable-length
  "This property contains the number of bytes (or objects) in the queue
   ready to be read. The value provides introspection data regarding
   the status of the `highWaterMark`."
  ^js [read-stream]
  (.-readableLength ^js read-stream))

(defn readable-object-mode?
  "Getter for the property `objectMode` of a given `Readable` stream."
  ^js [read-stream]
  (.-readableObjectMode ^js read-stream))

(defn destroyed?
  "Is `true` after `readable.destroy()` has been called."
  ^js [read-stream]
  (.-destroyed ^js read-stream))

(defn set-destroyed!
  "Is `true` after `readable.destroy()` has been called."
  ^js [read-stream value]
  (set! (.-destroyed ^js read-stream) value))

(defn closed?
  "Is true after 'close' has been emitted."
  ^js [read-stream]
  (.-closed ^js read-stream))

(defn errored
  "Returns error if the stream has been destroyed with an error."
  ^js [read-stream]
  (.-errored ^js read-stream))

(defn read
  "The `readable.read()` method reads data out of the internal buffer and
   returns it. If no data is available to be read, `null` is returned. By default,
   the data is returned as a `Buffer` object unless an encoding has been
   specified using the `readable.setEncoding()` method or the stream is operating
   in object mode.
   
   The optional `size` argument specifies a specific number of bytes to read. If`size` bytes are not available to be read, `null` will be returned _unless_the stream has ended, in which
   case all of the data remaining in the internal
   buffer will be returned.
   
   If the `size` argument is not specified, all of the data contained in the
   internal buffer will be returned.
   
   The `size` argument must be less than or equal to 1 GiB.
   
   The `readable.read()` method should only be called on `Readable` streams
   operating in paused mode. In flowing mode, `readable.read()` is called
   automatically until the internal buffer is fully drained.
   
   ```js
   const readable = getReadableStreamSomehow();
   
   // 'readable' may be triggered multiple times as data is buffered in
   readable.on('readable', () => {
     let chunk;
     console.log('Stream is readable (new data received in buffer)');
     // Use a loop to make sure we read all currently available data
     while (null !== (chunk = readable.read())) {
       console.log(`Read ${chunk.length} bytes of data...`);
     }
   });
   
   // 'end' will be triggered once when there is no more data available
   readable.on('end', () => {
     console.log('Reached end of stream.');
   });
   ```
   
   Each call to `readable.read()` returns a chunk of data, or `null`. The chunks
   are not concatenated. A `while` loop is necessary to consume all data
   currently in the buffer. When reading a large file `.read()` may return `null`,
   having consumed all buffered content so far, but there is still more data to
   come not yet buffered. In this case a new `'readable'` event will be emitted
   when there is more data in the buffer. Finally the `'end'` event will be
   emitted when there is no more data to come.
   
   Therefore to read a file's whole contents from a `readable`, it is necessary
   to collect chunks across multiple `'readable'` events:
   
   ```js
   const chunks = [];
   
   readable.on('readable', () => {
     let chunk;
     while (null !== (chunk = readable.read())) {
       chunks.push(chunk);
     }
   });
   
   readable.on('end', () => {
     const content = chunks.join('');
   });
   ```
   
   A `Readable` stream in object mode will always return a single item from
   a call to `readable.read(size)`, regardless of the value of the`size` argument.
   
   If the `readable.read()` method returns a chunk of data, a `'data'` event will
   also be emitted.
   
   Calling {@link read } after the `'end'` event has
   been emitted will return `null`. No runtime error will be raised."
  (^js [read-stream]
   (.read ^js read-stream))
  (^js [read-stream size]
   (.read ^js read-stream size)))

(defn set-encoding
  "The `readable.setEncoding()` method sets the character encoding for
   data read from the `Readable` stream.
   
   By default, no encoding is assigned and stream data will be returned as`Buffer` objects. Setting an encoding causes the stream data
   to be returned as strings of the specified encoding rather than as `Buffer`objects. For instance, calling `readable.setEncoding('utf8')` will cause the
   output data to be interpreted as UTF-8 data, and passed as strings. Calling`readable.setEncoding('hex')` will cause the data to be encoded in hexadecimal
   string format.
   
   The `Readable` stream will properly handle multi-byte characters delivered
   through the stream that would otherwise become improperly decoded if simply
   pulled from the stream as `Buffer` objects.
   
   ```js
   const readable = getReadableStreamSomehow();
   readable.setEncoding('utf8');
   readable.on('data', (chunk) => {
     assert.equal(typeof chunk, 'string');
     console.log('Got %d characters of string data:', chunk.length);
   });
   ```"
  ^js [read-stream encoding]
  (.setEncoding ^js read-stream encoding))

(defn pause
  "The `readable.pause()` method will cause a stream in flowing mode to stop
   emitting `'data'` events, switching out of flowing mode. Any data that
   becomes available will remain in the internal buffer.
   
   ```js
   const readable = getReadableStreamSomehow();
   readable.on('data', (chunk) => {
     console.log(`Received ${chunk.length} bytes of data.`);
     readable.pause();
     console.log('There will be no additional data for 1 second.');
     setTimeout(() => {
       console.log('Now data will start flowing again.');
       readable.resume();
     }, 1000);
   });
   ```
   
   The `readable.pause()` method has no effect if there is a `'readable'`event listener."
  ^js [read-stream]
  (.pause ^js read-stream))

(defn resume
  "The `readable.resume()` method causes an explicitly paused `Readable` stream to
   resume emitting `'data'` events, switching the stream into flowing mode.
   
   The `readable.resume()` method can be used to fully consume the data from a
   stream without actually processing any of that data:
   
   ```js
   getReadableStreamSomehow()
     .resume()
     .on('end', () => {
       console.log('Reached the end, but did not read anything.');
     });
   ```
   
   The `readable.resume()` method has no effect if there is a `'readable'`event listener."
  ^js [read-stream]
  (.resume ^js read-stream))

(defn paused?
  "The `readable.isPaused()` method returns the current operating state of the`Readable`. This is used primarily by the mechanism that underlies the`readable.pipe()` method. In most
   typical cases, there will be no reason to
   use this method directly.
   
   ```js
   const readable = new stream.Readable();
   
   readable.isPaused(); // === false
   readable.pause();
   readable.isPaused(); // === true
   readable.resume();
   readable.isPaused(); // === false
   ```"
  ^js [read-stream]
  (.isPaused ^js read-stream))

(defn unpipe
  "The `readable.unpipe()` method detaches a `Writable` stream previously attached
   using the {@link pipe } method.
   
   If the `destination` is not specified, then _all_ pipes are detached.
   
   If the `destination` is specified, but no pipe is set up for it, then
   the method does nothing.
   
   ```js
   const fs = require('fs');
   const readable = getReadableStreamSomehow();
   const writable = fs.createWriteStream('file.txt');
   // All the data from readable goes into 'file.txt',
   // but only for the first second.
   readable.pipe(writable);
   setTimeout(() => {
     console.log('Stop writing to file.txt.');
     readable.unpipe(writable);
     console.log('Manually close the file stream.');
     writable.end();
   }, 1000);
   ```"
  (^js [read-stream]
   (.unpipe ^js read-stream))
  (^js [read-stream destination]
   (.unpipe ^js read-stream destination)))

(defn unshift
  "Passing `chunk` as `null` signals the end of the stream (EOF) and behaves the
   same as `readable.push(null)`, after which no more data can be written. The EOF
   signal is put at the end of the buffer and any buffered data will still be
   flushed.
   
   The `readable.unshift()` method pushes a chunk of data back into the internal
   buffer. This is useful in certain situations where a stream is being consumed by
   code that needs to \"un-consume\" some amount of data that it has optimistically
   pulled out of the source, so that the data can be passed on to some other party.
   
   The `stream.unshift(chunk)` method cannot be called after the `'end'` event
   has been emitted or a runtime error will be thrown.
   
   Developers using `stream.unshift()` often should consider switching to
   use of a `Transform` stream instead. See the `API for stream implementers` section for more information.
   
   ```js
   // Pull off a header delimited by \\n\\n.
   // Use unshift() if we get too much.
   // Call the callback with (error, header, stream).
   const { StringDecoder } = require('string_decoder');
   function parseHeader(stream, callback) {
     stream.on('error', callback);
     stream.on('readable', onReadable);
     const decoder = new StringDecoder('utf8');
     let header = '';
     function onReadable() {
       let chunk;
       while (null !== (chunk = stream.read())) {
         const str = decoder.write(chunk);
         if (str.includes('\\n\\n')) {
           // Found the header boundary.
           const split = str.split(/\\n\\n/);
           header += split.shift();
           const remaining = split.join('\\n\\n');
           const buf = Buffer.from(remaining, 'utf8');
           stream.removeListener('error', callback);
           // Remove the 'readable' listener before unshifting.
           stream.removeListener('readable', onReadable);
           if (buf.length)
             stream.unshift(buf);
           // Now the body of the message can be read from the stream.
           callback(null, header, stream);
           return;
         }
         // Still reading the header.
         header += str;
       }
     }
   }
   ```
   
   Unlike {@link push }, `stream.unshift(chunk)` will not
   end the reading process by resetting the internal reading state of the stream.
   This can cause unexpected results if `readable.unshift()` is called during a
   read (i.e. from within a {@link _read } implementation on a
   custom stream). Following the call to `readable.unshift()` with an immediate {@link push } will reset the reading state appropriately,
   however it is best to simply avoid calling `readable.unshift()` while in the
   process of performing a read."
  (^js [read-stream chunk]
   (.unshift ^js read-stream chunk))
  (^js [read-stream chunk encoding]
   (.unshift ^js read-stream chunk encoding)))

(defn wrap
  "Prior to Node.js 0.10, streams did not implement the entire `stream` module API
   as it is currently defined. (See `Compatibility` for more information.)
   
   When using an older Node.js library that emits `'data'` events and has a {@link pause } method that is advisory only, the`readable.wrap()` method can be used to create a `Readable`
   stream that uses
   the old stream as its data source.
   
   It will rarely be necessary to use `readable.wrap()` but the method has been
   provided as a convenience for interacting with older Node.js applications and
   libraries.
   
   ```js
   const { OldReader } = require('./old-api-module.js');
   const { Readable } = require('stream');
   const oreader = new OldReader();
   const myReader = new Readable().wrap(oreader);
   
   myReader.on('readable', () => {
     myReader.read(); // etc.
   });
   ```"
  ^js [read-stream stream]
  (.wrap ^js read-stream stream))

(defn push?
  (^js [read-stream chunk]
   (.push ^js read-stream chunk))
  (^js [read-stream chunk encoding]
   (.push ^js read-stream chunk encoding)))

(defn destroy
  "Destroy the stream. Optionally emit an `'error'` event, and emit a `'close'`event (unless `emitClose` is set to `false`). After this call, the readable
   stream will release any internal resources and subsequent calls to `push()`will be ignored.
   
   Once `destroy()` has been called any further calls will be a no-op and no
   further errors except from `_destroy()` may be emitted as `'error'`.
   
   Implementors should not override this method, but instead implement `readable._destroy()`."
  (^js [read-stream]
   (.destroy ^js read-stream))
  (^js [read-stream error]
   (.destroy ^js read-stream error)))

(defn emit?
  {:arglists '([read-stream event]
               [read-stream event args]
               [read-stream event chunk]
               [read-stream event err])}
  (^js [a b & more]
   (.. ^js a -emit (apply ^js a (to-array (cons b more)))))
  (^js [a b c]
   (.emit ^js a b c)))

(defn remove-listener
  ^js [read-stream event listener]
  (.removeListener ^js read-stream event listener))

(defn pipe
  (^js [read-stream destination]
   (.pipe ^js read-stream destination))
  (^js [read-stream destination options]
   (.pipe ^js read-stream destination options)))

(defn off
  "Alias for `emitter.removeListener()`."
  ^js [read-stream event-name listener]
  (.off ^js read-stream event-name listener))

(defn remove-all-listeners
  "Removes all listeners, or those of the specified `eventName`.
   
   It is bad practice to remove listeners added elsewhere in the code,
   particularly when the `EventEmitter` instance was created by some other
   component or module (e.g. sockets or file streams).
   
   Returns a reference to the `EventEmitter`, so that calls can be chained."
  (^js [read-stream]
   (.removeAllListeners ^js read-stream))
  (^js [read-stream event]
   (.removeAllListeners ^js read-stream event)))

(defn set-max-listeners
  "By default `EventEmitter`s will print a warning if more than `10` listeners are
   added for a particular event. This is a useful default that helps finding
   memory leaks. The `emitter.setMaxListeners()` method allows the limit to be
   modified for this specific `EventEmitter` instance. The value can be set to`Infinity` (or `0`) to indicate an unlimited number of listeners.
   
   Returns a reference to the `EventEmitter`, so that calls can be chained."
  ^js [read-stream n]
  (.setMaxListeners ^js read-stream n))

(defn max-listeners
  "Returns the current max listener value for the `EventEmitter` which is either
   set by `emitter.setMaxListeners(n)` or defaults to {@link defaultMaxListeners }."
  ^js [read-stream]
  (.getMaxListeners ^js read-stream))

(defn listeners
  "Returns a copy of the array of listeners for the event named `eventName`.
   
   ```js
   server.on('connection', (stream) => {
     console.log('someone connected!');
   });
   console.log(util.inspect(server.listeners('connection')));
   // Prints: [ [Function] ]
   ```"
  ^js [read-stream event-name]
  (.listeners ^js read-stream event-name))

(defn raw-listeners
  "Returns a copy of the array of listeners for the event named `eventName`,
   including any wrappers (such as those created by `.once()`).
   
   ```js
   const emitter = new EventEmitter();
   emitter.once('log', () => console.log('log once'));
   
   // Returns a new Array with a function `onceWrapper` which has a property
   // `listener` which contains the original listener bound above
   const listeners = emitter.rawListeners('log');
   const logFnWrapper = listeners[0];
   
   // Logs \"log once\" to the console and does not unbind the `once` event
   logFnWrapper.listener();
   
   // Logs \"log once\" to the console and removes the listener
   logFnWrapper();
   
   emitter.on('log', () => console.log('log persistently'));
   // Will return a new Array with a single function bound by `.on()` above
   const newListeners = emitter.rawListeners('log');
   
   // Logs \"log persistently\" twice
   newListeners[0]();
   emitter.emit('log');
   ```"
  ^js [read-stream event-name]
  (.rawListeners ^js read-stream event-name))

(defn listener-count
  "Returns the number of listeners listening to the event named `eventName`."
  ^js [read-stream event-name]
  (.listenerCount ^js read-stream event-name))

(defn event-names
  "Returns an array listing the events for which the emitter has registered
   listeners. The values in the array are strings or `Symbol`s.
   
   ```js
   const EventEmitter = require('events');
   const myEE = new EventEmitter();
   myEE.on('foo', () => {});
   myEE.on('bar', () => {});
   
   const sym = Symbol('symbol');
   myEE.on(sym, () => {});
   
   console.log(myEE.eventNames());
   // Prints: [ 'foo', 'bar', Symbol(symbol) ]
   ```"
  ^js [read-stream]
  (.eventNames ^js read-stream))
