(ns todo-cljs.core
  (:require 
   [reagent.dom :as rd]
   [todo-cljs.header :refer [header]]
   [todo-cljs.todos :refer [todos-list]]))

(enable-console-print!)


(defn core []
  [:div
   [header]
   [todos-list]
  ])

(rd/render [core]
           (. js/document (getElementById "app")))

