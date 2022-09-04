(ns todo-cljs.header)

(defonce header-state (atom {:text "ToDo List"}))

(defn header []

  [:div
   [:h1 (:text @header-state)]])