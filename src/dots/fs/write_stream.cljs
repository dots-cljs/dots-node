(ns dots.fs.write-stream
  "* Extends `stream.Writable`
   
   Instances of `fs.WriteStream` are created and returned using the {@link createWriteStream } function.")

(defn close
  "Closes `writeStream`. Optionally accepts a
   callback that will be executed once the `writeStream`is closed."
  (^js [write-stream]
   (.close ^js write-stream))
  (^js [write-stream callback]
   (.close ^js write-stream callback)))

(defn bytes-written
  "The number of bytes written so far. Does not include data that is still queued
   for writing."
  ^js [write-stream]
  (.-bytesWritten ^js write-stream))

(defn set-bytes-written!
  "The number of bytes written so far. Does not include data that is still queued
   for writing."
  ^js [write-stream value]
  (set! (.-bytesWritten ^js write-stream) value))

(defn path
  "The path to the file the stream is writing to as specified in the first
   argument to {@link createWriteStream }. If `path` is passed as a string, then`writeStream.path` will be a string. If `path` is passed as a `Buffer`, then`writeStream.path` will be a
   `Buffer`."
  ^js [write-stream]
  (.-path ^js write-stream))

(defn set-path!
  "The path to the file the stream is writing to as specified in the first
   argument to {@link createWriteStream }. If `path` is passed as a string, then`writeStream.path` will be a string. If `path` is passed as a `Buffer`, then`writeStream.path` will be a
   `Buffer`."
  ^js [write-stream value]
  (set! (.-path ^js write-stream) value))

(defn pending?
  "This property is `true` if the underlying file has not been opened yet,
   i.e. before the `'ready'` event is emitted."
  ^js [write-stream]
  (.-pending ^js write-stream))

(defn set-pending!
  "This property is `true` if the underlying file has not been opened yet,
   i.e. before the `'ready'` event is emitted."
  ^js [write-stream value]
  (set! (.-pending ^js write-stream) value))

(defn add-listener
  "events.EventEmitter
     1. open
     2. close
     3. ready"
  ^js [write-stream event listener]
  (.addListener ^js write-stream event listener))

(defn on
  ^js [write-stream event listener]
  (.on ^js write-stream event listener))

(defn once
  ^js [write-stream event listener]
  (.once ^js write-stream event listener))

(defn prepend-listener
  ^js [write-stream event listener]
  (.prependListener ^js write-stream event listener))

(defn prepend-once-listener
  ^js [write-stream event listener]
  (.prependOnceListener ^js write-stream event listener))

(defn writable?
  "Is `true` if it is safe to call `writable.write()`, which means
   the stream has not been destroyed, errored or ended."
  ^js [write-stream]
  (.-writable ^js write-stream))

(defn writable-ended?
  "Is `true` after `writable.end()` has been called. This property
   does not indicate whether the data has been flushed, for this use `writable.writableFinished` instead."
  ^js [write-stream]
  (.-writableEnded ^js write-stream))

(defn writable-finished?
  "Is set to `true` immediately before the `'finish'` event is emitted."
  ^js [write-stream]
  (.-writableFinished ^js write-stream))

(defn writable-high-water-mark
  "Return the value of `highWaterMark` passed when creating this `Writable`."
  ^js [write-stream]
  (.-writableHighWaterMark ^js write-stream))

(defn writable-length
  "This property contains the number of bytes (or objects) in the queue
   ready to be written. The value provides introspection data regarding
   the status of the `highWaterMark`."
  ^js [write-stream]
  (.-writableLength ^js write-stream))

(defn writable-object-mode?
  "Getter for the property `objectMode` of a given `Writable` stream."
  ^js [write-stream]
  (.-writableObjectMode ^js write-stream))

(defn writable-corked
  "Number of times `writable.uncork()` needs to be
   called in order to fully uncork the stream."
  ^js [write-stream]
  (.-writableCorked ^js write-stream))

(defn destroyed?
  "Is `true` after `writable.destroy()` has been called."
  ^js [write-stream]
  (.-destroyed ^js write-stream))

(defn set-destroyed!
  "Is `true` after `writable.destroy()` has been called."
  ^js [write-stream value]
  (set! (.-destroyed ^js write-stream) value))

(defn closed?
  "Is true after 'close' has been emitted."
  ^js [write-stream]
  (.-closed ^js write-stream))

(defn errored
  "Returns error if the stream has been destroyed with an error."
  ^js [write-stream]
  (.-errored ^js write-stream))

(defn writable-need-drain?
  "Is `true` if the stream's buffer has been full and stream will emit 'drain'."
  ^js [write-stream]
  (.-writableNeedDrain ^js write-stream))

(defn write?
  "The `writable.write()` method writes some data to the stream, and calls the
   supplied `callback` once the data has been fully handled. If an error
   occurs, the `callback` will be called with the error as its
   first argument. The `callback` is called asynchronously and before `'error'` is
   emitted.
   
   The return value is `true` if the internal buffer is less than the`highWaterMark` configured when the stream was created after admitting `chunk`.
   If `false` is returned, further attempts to write data to the stream should
   stop until the `'drain'` event is emitted.
   
   While a stream is not draining, calls to `write()` will buffer `chunk`, and
   return false. Once all currently buffered chunks are drained (accepted for
   delivery by the operating system), the `'drain'` event will be emitted.
   Once `write()` returns false, do not write more chunks
   until the `'drain'` event is emitted. While calling `write()` on a stream that
   is not draining is allowed, Node.js will buffer all written chunks until
   maximum memory usage occurs, at which point it will abort unconditionally.
   Even before it aborts, high memory usage will cause poor garbage collector
   performance and high RSS (which is not typically released back to the system,
   even after the memory is no longer required). Since TCP sockets may never
   drain if the remote peer does not read the data, writing a socket that is
   not draining may lead to a remotely exploitable vulnerability.
   
   Writing data while the stream is not draining is particularly
   problematic for a `Transform`, because the `Transform` streams are paused
   by default until they are piped or a `'data'` or `'readable'` event handler
   is added.
   
   If the data to be written can be generated or fetched on demand, it is
   recommended to encapsulate the logic into a `Readable` and use {@link pipe }. However, if calling `write()` is preferred, it is
   possible to respect backpressure and avoid memory issues using the `'drain'` event:
   
   ```js
   function write(data, cb) {
     if (!stream.write(data)) {
       stream.once('drain', cb);
     } else {
       process.nextTick(cb);
     }
   }
   
   // Wait for cb to be called before doing any other write.
   write('hello', () => {
     console.log('Write completed, do more writes now.');
   });
   ```
   
   A `Writable` stream in object mode will always ignore the `encoding` argument."
  {:arglists '([write-stream chunk]
               [write-stream chunk callback]
               [write-stream chunk encoding]
               [write-stream chunk encoding callback])}
  (^js [write-stream chunk]
   (.write ^js write-stream chunk))
  (^js [a b c]
   (.write ^js a b c))
  (^js [write-stream chunk encoding callback]
   (.write ^js write-stream chunk encoding callback)))

(defn set-default-encoding
  "The `writable.setDefaultEncoding()` method sets the default `encoding` for a `Writable` stream."
  ^js [write-stream encoding]
  (.setDefaultEncoding ^js write-stream encoding))

(defn end
  "Calling the `writable.end()` method signals that no more data will be written
   to the `Writable`. The optional `chunk` and `encoding` arguments allow one
   final additional chunk of data to be written immediately before closing the
   stream.
   
   Calling the {@link write } method after calling {@link end } will raise an error.
   
   ```js
   // Write 'hello, ' and then end with 'world!'.
   const fs = require('fs');
   const file = fs.createWriteStream('example.txt');
   file.write('hello, ');
   file.end('world!');
   // Writing more now is not allowed!
   ```"
  {:arglists '([write-stream]
               [write-stream cb]
               [write-stream chunk]
               [write-stream chunk cb]
               [write-stream chunk encoding]
               [write-stream chunk encoding cb])}
  (^js [write-stream]
   (.end ^js write-stream))
  (^js [a b]
   (.end ^js a b))
  (^js [a b c]
   (.end ^js a b c))
  (^js [write-stream chunk encoding cb]
   (.end ^js write-stream chunk encoding cb)))

(defn cork
  "The `writable.cork()` method forces all written data to be buffered in memory.
   The buffered data will be flushed when either the {@link uncork } or {@link end } methods are called.
   
   The primary intent of `writable.cork()` is to accommodate a situation in which
   several small chunks are written to the stream in rapid succession. Instead of
   immediately forwarding them to the underlying destination, `writable.cork()`buffers all the chunks until `writable.uncork()` is called, which will pass them
   all to `writable._writev()`, if present. This prevents a head-of-line blocking
   situation where data is being buffered while waiting for the first small chunk
   to be processed. However, use of `writable.cork()` without implementing`writable._writev()` may have an adverse effect on throughput.
   
   See also: `writable.uncork()`, `writable._writev()`."
  ^js [write-stream]
  (.cork ^js write-stream))

(defn uncork
  "The `writable.uncork()` method flushes all data buffered since {@link cork } was called.
   
   When using `writable.cork()` and `writable.uncork()` to manage the buffering
   of writes to a stream, defer calls to `writable.uncork()` using`process.nextTick()`. Doing so allows batching of all`writable.write()` calls that occur within a given Node.js event
   loop phase.
   
   ```js
   stream.cork();
   stream.write('some ');
   stream.write('data ');
   process.nextTick(() => stream.uncork());
   ```
   
   If the `writable.cork()` method is called multiple times on a stream, the
   same number of calls to `writable.uncork()` must be called to flush the buffered
   data.
   
   ```js
   stream.cork();
   stream.write('some ');
   stream.cork();
   stream.write('data ');
   process.nextTick(() => {
     stream.uncork();
     // The data will not be flushed until uncork() is called a second time.
     stream.uncork();
   });
   ```
   
   See also: `writable.cork()`."
  ^js [write-stream]
  (.uncork ^js write-stream))

(defn destroy
  "Destroy the stream. Optionally emit an `'error'` event, and emit a `'close'`event (unless `emitClose` is set to `false`). After this call, the writable
   stream has ended and subsequent calls to `write()` or `end()` will result in
   an `ERR_STREAM_DESTROYED` error.
   This is a destructive and immediate way to destroy a stream. Previous calls to`write()` may not have drained, and may trigger an `ERR_STREAM_DESTROYED` error.
   Use `end()` instead of destroy if data should flush before close, or wait for
   the `'drain'` event before destroying the stream.
   
   Once `destroy()` has been called any further calls will be a no-op and no
   further errors except from `_destroy()` may be emitted as `'error'`.
   
   Implementors should not override this method,
   but instead implement `writable._destroy()`."
  (^js [write-stream]
   (.destroy ^js write-stream))
  (^js [write-stream error]
   (.destroy ^js write-stream error)))

(defn emit?
  {:arglists '([write-stream event]
               [write-stream event args]
               [write-stream event err]
               [write-stream event src])}
  (^js [a b & more]
   (.. ^js a -emit (apply ^js a (to-array (cons b more)))))
  (^js [a b c]
   (.emit ^js a b c)))

(defn remove-listener
  ^js [write-stream event listener]
  (.removeListener ^js write-stream event listener))

(defn pipe
  (^js [write-stream destination]
   (.pipe ^js write-stream destination))
  (^js [write-stream destination options]
   (.pipe ^js write-stream destination options)))

(defn off
  "Alias for `emitter.removeListener()`."
  ^js [write-stream event-name listener]
  (.off ^js write-stream event-name listener))

(defn remove-all-listeners
  "Removes all listeners, or those of the specified `eventName`.
   
   It is bad practice to remove listeners added elsewhere in the code,
   particularly when the `EventEmitter` instance was created by some other
   component or module (e.g. sockets or file streams).
   
   Returns a reference to the `EventEmitter`, so that calls can be chained."
  (^js [write-stream]
   (.removeAllListeners ^js write-stream))
  (^js [write-stream event]
   (.removeAllListeners ^js write-stream event)))

(defn set-max-listeners
  "By default `EventEmitter`s will print a warning if more than `10` listeners are
   added for a particular event. This is a useful default that helps finding
   memory leaks. The `emitter.setMaxListeners()` method allows the limit to be
   modified for this specific `EventEmitter` instance. The value can be set to`Infinity` (or `0`) to indicate an unlimited number of listeners.
   
   Returns a reference to the `EventEmitter`, so that calls can be chained."
  ^js [write-stream n]
  (.setMaxListeners ^js write-stream n))

(defn max-listeners
  "Returns the current max listener value for the `EventEmitter` which is either
   set by `emitter.setMaxListeners(n)` or defaults to {@link defaultMaxListeners }."
  ^js [write-stream]
  (.getMaxListeners ^js write-stream))

(defn listeners
  "Returns a copy of the array of listeners for the event named `eventName`.
   
   ```js
   server.on('connection', (stream) => {
     console.log('someone connected!');
   });
   console.log(util.inspect(server.listeners('connection')));
   // Prints: [ [Function] ]
   ```"
  ^js [write-stream event-name]
  (.listeners ^js write-stream event-name))

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
  ^js [write-stream event-name]
  (.rawListeners ^js write-stream event-name))

(defn listener-count
  "Returns the number of listeners listening to the event named `eventName`."
  ^js [write-stream event-name]
  (.listenerCount ^js write-stream event-name))

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
  ^js [write-stream]
  (.eventNames ^js write-stream))
