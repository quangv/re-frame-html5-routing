# Re-frame Example/Starter

Figwheel + Re-Frame + Bidi + Pushy (HTML5 no-hash routing)

1. Using re-frame-template `lein new re-frame my-app +routes +aliases` - https://github.com/Day8/re-frame-template
2. `dev-server/handler` by @mjg123 - https://github.com/bhauman/lein-figwheel/issues/344#issuecomment-243922855
3. `bidi`, `pushy` No-hashes bidirectional routing by J. Pablo Fernández - https://pupeno.com/2015/08/26/no-hashes-bidirectional-routing-in-re-frame-with-bidi-and-pushy/ 


Thanks everyone!




A [re-frame](https://github.com/Day8/re-frame) application designed to ... well, that part is up to you.

## Development Mode

### Run application:

```
lein dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

## Production Build


To compile clojurescript to javascript:

```
lein build
```
