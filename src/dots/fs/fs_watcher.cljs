(ns dots.fs.fs-watcher)

(defn close
  "Stop watching for changes on the given `fs.FSWatcher`. Once stopped, the `fs.FSWatcher` object is no longer usable."
  ^js [fs-watcher]
  (.close ^js fs-watcher))

(defn add-listener
  "events.EventEmitter
     1. change
     2. error"
  ^js [fs-watcher event listener]
  (.addListener ^js fs-watcher event listener))

(defn on
  ^js [fs-watcher event listener]
  (.on ^js fs-watcher event listener))

(defn once
  ^js [fs-watcher event listener]
  (.once ^js fs-watcher event listener))

(defn prepend-listener
  ^js [fs-watcher event listener]
  (.prependListener ^js fs-watcher event listener))

(defn prepend-once-listener
  ^js [fs-watcher event listener]
  (.prependOnceListener ^js fs-watcher event listener))

(defn remove-listener
  "Removes the specified `listener` from the listener array for the event named`eventName`.
   
   ```js
   const callback = (stream) => {
     console.log('someone connected!');
   };
   server.on('connection', callback);
   // ...
   server.removeListener('connection', callback);
   ```
   
   `removeListener()` will remove, at most, one instance of a listener from the
   listener array. If any single listener has been added multiple times to the
   listener array for the specified `eventName`, then `removeListener()` must be
   called multiple times to remove each instance.
   
   Once an event is emitted, all listeners attached to it at the
   time of emitting are called in order. This implies that any`removeListener()` or `removeAllListeners()` calls _after_ emitting and _before_ the last listener finishes execution
   will not remove them from`emit()` in progress. Subsequent events behave as expected.
   
   ```js
   const myEmitter = new MyEmitter();
   
   const callbackA = () => {
     console.log('A');
     myEmitter.removeListener('event', callbackB);
   };
   
   const callbackB = () => {
     console.log('B');
   };
   
   myEmitter.on('event', callbackA);
   
   myEmitter.on('event', callbackB);
   
   // callbackA removes listener callbackB but it will still be called.
   // Internal listener array at time of emit [callbackA, callbackB]
   myEmitter.emit('event');
   // Prints:
   //   A
   //   B
   
   // callbackB is now removed.
   // Internal listener array [callbackA]
   myEmitter.emit('event');
   // Prints:
   //   A
   ```
   
   Because listeners are managed using an internal array, calling this will
   change the position indices of any listener registered _after_ the listener
   being removed. This will not impact the order in which listeners are called,
   but it means that any copies of the listener array as returned by
   the `emitter.listeners()` method will need to be recreated.
   
   When a single function has been added as a handler multiple times for a single
   event (as in the example below), `removeListener()` will remove the most
   recently added instance. In the example the `once('ping')`listener is removed:
   
   ```js
   const ee = new EventEmitter();
   
   function pong() {
     console.log('pong');
   }
   
   ee.on('ping', pong);
   ee.once('ping', pong);
   ee.removeListener('ping', pong);
   
   ee.emit('ping');
   ee.emit('ping');
   ```
   
   Returns a reference to the `EventEmitter`, so that calls can be chained."
  ^js [fs-watcher event-name listener]
  (.removeListener ^js fs-watcher event-name listener))

(defn off
  "Alias for `emitter.removeListener()`."
  ^js [fs-watcher event-name listener]
  (.off ^js fs-watcher event-name listener))

(defn remove-all-listeners
  "Removes all listeners, or those of the specified `eventName`.
   
   It is bad practice to remove listeners added elsewhere in the code,
   particularly when the `EventEmitter` instance was created by some other
   component or module (e.g. sockets or file streams).
   
   Returns a reference to the `EventEmitter`, so that calls can be chained."
  (^js [fs-watcher]
   (.removeAllListeners ^js fs-watcher))
  (^js [fs-watcher event]
   (.removeAllListeners ^js fs-watcher event)))

(defn set-max-listeners
  "By default `EventEmitter`s will print a warning if more than `10` listeners are
   added for a particular event. This is a useful default that helps finding
   memory leaks. The `emitter.setMaxListeners()` method allows the limit to be
   modified for this specific `EventEmitter` instance. The value can be set to`Infinity` (or `0`) to indicate an unlimited number of listeners.
   
   Returns a reference to the `EventEmitter`, so that calls can be chained."
  ^js [fs-watcher n]
  (.setMaxListeners ^js fs-watcher n))

(defn max-listeners
  "Returns the current max listener value for the `EventEmitter` which is either
   set by `emitter.setMaxListeners(n)` or defaults to {@link defaultMaxListeners }."
  ^js [fs-watcher]
  (.getMaxListeners ^js fs-watcher))

(defn listeners
  "Returns a copy of the array of listeners for the event named `eventName`.
   
   ```js
   server.on('connection', (stream) => {
     console.log('someone connected!');
   });
   console.log(util.inspect(server.listeners('connection')));
   // Prints: [ [Function] ]
   ```"
  ^js [fs-watcher event-name]
  (.listeners ^js fs-watcher event-name))

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
  ^js [fs-watcher event-name]
  (.rawListeners ^js fs-watcher event-name))

(defn emit?
  "Synchronously calls each of the listeners registered for the event named`eventName`, in the order they were registered, passing the supplied arguments
   to each.
   
   Returns `true` if the event had listeners, `false` otherwise.
   
   ```js
   const EventEmitter = require('events');
   const myEmitter = new EventEmitter();
   
   // First listener
   myEmitter.on('event', function firstListener() {
     console.log('Helloooo! first listener');
   });
   // Second listener
   myEmitter.on('event', function secondListener(arg1, arg2) {
     console.log(`event with parameters ${arg1}, ${arg2} in second listener`);
   });
   // Third listener
   myEmitter.on('event', function thirdListener(...args) {
     const parameters = args.join(', ');
     console.log(`event with parameters ${parameters} in third listener`);
   });
   
   console.log(myEmitter.listeners('event'));
   
   myEmitter.emit('event', 1, 2, 3, 4, 5);
   
   // Prints:
   // [
   //   [Function: firstListener],
   //   [Function: secondListener],
   //   [Function: thirdListener]
   // ]
   // Helloooo! first listener
   // event with parameters 1, 2 in second listener
   // event with parameters 1, 2, 3, 4, 5 in third listener
   ```"
  ^js [fs-watcher event-name & args]
  (.. ^js fs-watcher -emit (apply ^js fs-watcher (to-array (cons event-name args)))))

(defn listener-count
  "Returns the number of listeners listening to the event named `eventName`."
  ^js [fs-watcher event-name]
  (.listenerCount ^js fs-watcher event-name))

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
  ^js [fs-watcher]
  (.eventNames ^js fs-watcher))
